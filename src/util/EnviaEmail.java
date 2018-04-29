package util;

import modelo.Archivo_Class;
import java.util.List;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.*;

public class EnviaEmail 
{

     public String origen;
     public String psswd;
     public List<List<String>> destino;
     public Archivo_Class[] adjunto;
     public String asunto;
     public String cuerpo;

    public EnviaEmail() 
    {
        
    }

    //metodo que recibe y envia el email
    public EnviaEmail(String origen, String psswd, List<List<String>> destino, 
            String asunto, String cuerpo)
    { 
        this.origen = origen;
        this.psswd = psswd;
        this.destino = destino;
        this.asunto = asunto;
        this.cuerpo = cuerpo;
        
    } 

    public Boolean enviar() 
    {
        Properties props = new Properties();        //propiedades a agragar
        props.put("mail.smtp.user", this.origen);   //correo origen
        props.put("mail.smtp.port", "587");         //puerto de salida
        props.put("mail.smtp.starttls.enable", "true");//inicializar el servidor
        props.put("mail.smtp.auth", "true");        //autentificacion  

        String identifica = origen.substring(
                origen.indexOf("@") + 1,
                origen.indexOf("@") + 6);       //#cadena que obtiene la cadena igual a 'gmail'

        if (identifica.equals("gmail")) 
        {                                        //#si el correo es de tipo gmail
            //Agrega nuevas propiedades 
            props.put("mail.smtp.host", "smtp.gmail.com");  //#tipo de servidor            
            props.put("mail.smtp.socketFactory.port", "465");//#activar el puerto
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.socketFactory.fallback", "false");
        } else
        {  //#de lo contrario supondremos que es hotmail
            props.put("mail.smtp.host", "smtp.live.com");//#tipo de servidor
        }

        try
        {

            Authenticator auth = new autentificadorSMTP();      //autentificar el correo
            Session session = Session.getInstance(props, auth); //se inica una session
            // session.setDebug(true);//#se puede habilitar cuando se esta en modo desarrollo
            MimeMessage msg = new MimeMessage(session);//se crea un objeto donde ira la estructura del correo
            MimeMultipart multiParte = new MimeMultipart();//####
 
            //#INICIO AGREGAR MULTIPLES ADJUNTOS
            if (adjunto != null)
            {                                                 //#Si biene algun archivo adjunto
                for (Archivo_Class adjunto1 : adjunto) 
                {                                             //Recorre la lista de archivos
                    BodyPart adj = new MimeBodyPart();        //#Instancea un parte del mensaje
                    adj.setDataHandler(new DataHandler(new FileDataSource(adjunto1.ruta)));//#Setea un nuevo adjunto al correo
                    adj.setFileName(adjunto1.nombre);         //#Agrega el nombre al archivo
                    multiParte.addBodyPart(adj);              //#Agrega el cuerpo del mensaje a la multiparte
                } 
            }
            
            //#INICIO AGREGAR MULTIPLES DESTINATARIOS
            for (int i = 0; i < this.destino.get(0).size(); i++) 
            {                                                           //#Recorre lista de destinos
                    msg.addRecipient(Message.RecipientType.TO,
                           new InternetAddress(
                                   this.destino.get(0).get(i)))
                            ;                                           //#agrega el destinatario 
            }
            
          /*    
            //#INICIO AGREGAR MULTIPLES CC
            if (this.destino.get(1) != null)
            {                                                          //#Si existen destinatarios con copia
                for (int i = 0; i < this.destino.get(1).size(); i++) 
                {                                                      //#Recorre la lista del segundo indice
                    msg.addRecipient(Message.RecipientType.CC,
                            new InternetAddress(
                                    this.destino.get(1).get(i)
                            ));                                         //agrega el destinatario //####
                } 
            } 
            //#FIN AGREGA MULTIPLES CC
          
            //#INICIO AGREGAR MULTIPLES C0
            if (this.destino.get(2) != null)
            {                                                        //Si existen adestinatarios con copia oculta
                for (int i = 0; i < this.destino.get(2).size(); i++) 
                {                                                     //#Recorre lista
                    msg.addRecipient(Message.RecipientType.BCC,
                            new InternetAddress(
                                    this.destino.get(2).get(i)
                            ));                                       //#Agrega el destinatario 
                } 
            } 
            //#FIN AGREGAR MULTIPLES CO
        */
            BodyPart texto = new MimeBodyPart();            //#Crea el cuerpo del mensaje
            texto.setText(this.cuerpo);                     //#Setea el mensaje a la parte del mensaje
            msg.setSubject(this.asunto);                    //#Setea asunto
            msg.setFrom(new InternetAddress(this.origen));  //#Agrega la la propiedad del correo origen
            multiParte.addBodyPart(texto);                  //#Setea el texto al multparte    

            msg.setContent(multiParte);                     //#Setea todo el contenido del mensaje
            Transport.send(msg);                            //#Envia el mensaje

            return true;                                    //#Retorna true si se envio correctamente
        } catch (Exception mex) 
        {                                                   //#en caso de que ocurra un error se crea una excepcion
            return false;
        } 
        
    }

    private class autentificadorSMTP extends javax.mail.Authenticator 
    {

        @Override
        public PasswordAuthentication getPasswordAuthentication() 
        {
            return new PasswordAuthentication(origen, psswd);          //autentifica tanto el correo como la contraseña
        }
    }
}
