public class UsaListaDoble{
    
    public static void main (String[] args){
        ListaDoble lista = new ListaDoble();
        lista.insertaPrimerNodo("R");
        lista.imprimir();
        lista.insertaPrimerNodo("F");
        lista.imprimir();
        System.out.println(lista);
        lista.insertaAntesPrimerNodo("H");
        System.out.println(lista);
        lista.insertaAlFinal("Z");
        System.out.println(lista);
        lista.insertaEntreNodos("T", "R");
        System.out.println(lista);
        lista.insertaAntesPrimerNodo("K");
        System.out.println(lista);
        lista.insertaAlFinal("Ñ");
        System.out.println(lista);
        lista.borrarPrimerNodo();
        System.out.println(lista);
        lista.borrarUltimoNodo();
        System.out.println(lista);
        lista.borrarCualquierNodo("R");
        System.out.println(lista);
        
        String valorBuscado = "H";
        Node nodoEncontrado = lista.buscarNodoPorValor(valorBuscado);

        if (nodoEncontrado != null) {
            System.out.println("Nodo encontrado: " + nodoEncontrado.name);
        } else {
            System.out.println("Nodo con valor " + valorBuscado + " no encontrado.");
        }
        //agregar un nodo despuès de otro encontrado/buscado
        String valorABuscar = "H";
        String nuevoValor = "G";
        boolean exitoAdicion = lista.insertarDespuesDeNodo(valorBuscado, nuevoValor);

        if (exitoAdicion) {
            System.out.println("adición exitosa:");
            System.out.println(lista);
        } else {
            System.out.println("No se pudo añadir después del nodo con valor " + valorBuscado);
        }
        //Intercambiar nodos seleccionados
         String nodoA = "G";
        String nodoB = "Z";
        boolean exitoIntercambio = lista.intercambiarNodos(nodoA, nodoB);

        if (exitoIntercambio) {
            System.out.println("Intercambio exitoso:");
            System.out.println(lista);
        } else {
            System.out.println("No se pudo realizar el intercambio");
        }
        // Borrar el nodo con valor 
        String valorBuscad = "H";
        boolean exitoBorrado = lista.borrarNodo(valorBuscado);

        if (exitoBorrado) {
            System.out.println("Borrado exitoso:");
            System.out.println(lista);
        } else {
            System.out.println("No se pudo borrar el nodo con valor " + valorBuscado);
        }
    }
}