using System;
using WSDL.mensajes;

namespace WSDL.operaciones
{
    public class Operaciones : Mensajes
    {
        List<Tuple<int,string>> listaNombres = new List<Tuple<int,string>>();

        //Investigar nombre o tipo de variable repositorio y para que me sirve
        public string Saludar(string nombre)
        {
            var ultimoID = 0;
            if(listaNombres.Any())
            {
                 ultimoID = listaNombres.Last().Item1;
            }
            
            Console.WriteLine($"El utlimo ID ingresado es: {ultimoID}");
            int IdActual = ultimoID+1;
           
              foreach(Tuple<int,string> IDActual in listaNombres)
            {
                if (IdActual == IDActual.Item1)
                {
                    IdActual = IdActual+1;
                }
            }
             Console.WriteLine($"El ID actual es: {IdActual}");

            listaNombres.Add(new Tuple<int,string>(IdActual, nombre));
            string msj = $"Saludando a ID: {IdActual} Bienvenido  Nombre: {nombre}";

            Console.WriteLine(msj);
          //  listaNombres.Add(tupleNombres);
            Console.WriteLine("Ahora vamos a imprimir todos los nombres guardados en el sistema");
            foreach(Tuple<int,string> nombreActual in listaNombres)
            {
                Console.WriteLine($"Estamos actualmente en el nombre: {nombreActual.Item2} y el ID: {nombreActual.Item1}");
            }
            //El $ de pesos es para interpolar strings osea generar nuevos strings y generarlos como una variable viva
            return msj;
        }

        public string Mostrar(int id)
        {
            if (!listaNombres.Any())
            {
                string respuesta = "La lista se encuentra vacia en estos momentos";
                return respuesta;
            }

            Console.WriteLine($"Vamos a buscar el siguiente ID:  {id}");
             foreach(Tuple<int,string> IdActual in listaNombres)
            {
                if(id == IdActual.Item1)
                {
                    string repuesta = $"Felicidades encontramos el siguiente ID: {id} asociado al nombre: {IdActual.Item2}";
                    return repuesta;
                }

            }
            return $"Lo siento no encontre ningun elemento asociado al ID : {id}";
            
            
        }

    }

}
