/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasapalabraescritorio;

import conexion.ConexionURL;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

/**
 *
 * @author luis
 */
class AccesoDatos {

    static List<Pregunta> pedirPartida(String id_partida) {
        List<Pregunta> lista_preguntas=new ArrayList();
        try {
            String url="http://formadorestic.com/pasapalabra/carga.php?entorno=1&IDpartida="+id_partida;
            String xml=ConexionURL.peticionWeb(url);
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(new InputSource(new ByteArrayInputStream(xml.getBytes("utf-8"))));
            Element raiz=document.getRootElement();
            List hijos_raiz=raiz.getChildren();
            Element elemento_jugador=(Element)hijos_raiz.get(0);
            List<Element> lista_obj_pregunta=elemento_jugador.getChildren();
            for (Element elemento_pregunta: lista_obj_pregunta)
            {
                Element elemento_letra=elemento_pregunta.getChild("letra");
                Element elemento_posicion=elemento_pregunta.getChild("posicion");
                Element elemento_definicion=elemento_pregunta.getChild("definicion");
                Element elemento_solucion=elemento_pregunta.getChild("solucion");
                String letra=elemento_letra.getText();
                String posicion=elemento_posicion.getText();
                String definicion=elemento_definicion.getText();
                String solucion=elemento_solucion.getText();
                Pregunta p=new Pregunta(posicion, letra, definicion, solucion);
                lista_preguntas.add(p);
            }
            
        } catch (JDOMException ex) {
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(AccesoDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista_preguntas;
    }
    
    
}
