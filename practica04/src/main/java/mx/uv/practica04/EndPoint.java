package mx.uv.practica04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import https.t4is_uv_mx.saludos.BuscarSaludoRequest;
import https.t4is_uv_mx.saludos.BuscarSaludoResponse;
import https.t4is_uv_mx.saludos.DeleteSaludoRequest;
import https.t4is_uv_mx.saludos.DeleteSaludoResponse;
import https.t4is_uv_mx.saludos.EditSaludoRequest;
import https.t4is_uv_mx.saludos.EditSaludoResponse;
import https.t4is_uv_mx.saludos.SaludarRequest;
import https.t4is_uv_mx.saludos.SaludarResponse;


@Endpoint
public class EndPoint {
    @Autowired
    private ISaludador iSaludador;



    @PayloadRoot(namespace = "https://t4is.uv.mx/saludos",localPart = "SaludarRequest")

    @ResponsePayload
    public SaludarResponse Saludar(@RequestPayload SaludarRequest peticion){
        SaludarResponse respuesta = new SaludarResponse();
        respuesta.setRespuesta("Hola"+ peticion.getNombre());

        Saludador saludador = new Saludador();
        saludador.setNombre((peticion.getNombre()));
        iSaludador.save(saludador);
        return respuesta;
    }
    

    @PayloadRoot(namespace = "https://t4is.uv.mx/saludos",localPart = "BuscarSaludoRequest")

    @ResponsePayload
    public BuscarSaludoResponse Buscar(@RequestPayload BuscarSaludoRequest peticion){
        BuscarSaludoResponse respuesta = new BuscarSaludoResponse();
        Saludador saludador = new Saludador();
        saludador = iSaludador.findById(peticion.getId()).get();
        respuesta.setRespuesta("hola de nuevo "+saludador.getNombre());
        return respuesta;
    }

    @PayloadRoot(namespace = "https://t4is.uv.mx/saludos",localPart = "EditSaludoRequest")

    @ResponsePayload
    public EditSaludoResponse Editar(@RequestPayload EditSaludoRequest peticion){
        EditSaludoResponse respuesta = new EditSaludoResponse();
        Saludador saludador = new Saludador();
        saludador.setId(peticion.getId());
        saludador.setNombre(peticion.getNombre());
        
        iSaludador.save(saludador);
        respuesta.setRespuesta("El nuevo valor es "+ peticion.getId()+" y "+ peticion.getNombre());

        return respuesta;
    }

    @PayloadRoot(namespace = "https://t4is.uv.mx/saludos",localPart = "DeleteSaludoRequest")

    @ResponsePayload
    public DeleteSaludoResponse Borrar(@RequestPayload DeleteSaludoRequest peticion){
        DeleteSaludoResponse respuesta = new DeleteSaludoResponse();
        respuesta.setRespuesta("Haz borrado el ID: "+ peticion.getId());
        iSaludador.deleteById(peticion.getId());

        return respuesta;
    }
    
    
   
}
