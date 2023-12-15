public class ListaDoble{

    Node topForward;
    Node topBackward;

    //Métodos para los casos de inserción de nodos
    public boolean insertaPrimerNodo(String dato){
        if (topForward == null) { //La lista está vacía
            topForward = new Node();
            topForward.name = dato;
            topForward.previous = null;
            topForward.next = null;
            
            topBackward = topForward;

            return true;
        }
        else {
            return false;
        }
    }
    
    public void imprimir(){
        System.out.print("[X]"); 

        for (Node temp = this.topForward; temp != null; temp = temp.next){
            System.out.print(" <- [ " + temp.name + " ] -> ");
        }

        System.out.print("[X]"); 
    }
    
    public String toString(){
        String cadAux = "[X]";
        for (Node temp = this.topForward; temp != null; temp = temp.next){
            cadAux += " <- [ " + temp.name + " ] -> ";
        }

        cadAux += "[X]"; 

        return cadAux;
    }

    public void insertaAntesPrimerNodo(String nombre){
        Node temp; 
        temp = new Node ();
        temp.name = nombre;
        temp.next = this.topForward;
        this.topForward.previous = temp;
        this.topForward = temp;
        temp = null;
    }

    public void insertaAlFinal(String nombre){
        Node temp = new Node ();
        temp.name = nombre;
        temp.next = null;
        
        temp.previous = this.topBackward;
        this.topBackward.next = temp;
        this.topBackward = temp;
        temp = null;
    }

    public boolean insertaEntreNodos(String nombre, String buscado){
        Node temp = new Node();
        temp.name = nombre;
        Node temp2 = this.topForward;

        //boolean NodoNoEncontrado = true;

        while ( (temp2 != null) 
                && temp2.name.equals(buscado) == false ) {    
                 temp2 = temp2.next;
        }

        if (temp2 != null){  //Nodo buscado se encontró
            temp.next = temp2.next;
            temp2.next = temp;

            temp.previous = temp2;
            temp.next.previous = temp;

            temp = null;
            temp2 = null;
            
            return true;
        }
        else return false;
    } 
    //Métodos de borrado
    public void borrarPrimerNodo(){
        this.topForward = this.topForward.next;
        this.topForward.previous.next = null;
        this.topForward.previous = null;
    }

    public void borrarUltimoNodo(){
        this.topBackward = this.topBackward.previous;
        this.topBackward.next.previous = null;
        this.topBackward.next = null;
    }
    //Borrar cualquier nodo que no sea el primero
    public boolean borrarCualquierNodo(String buscado){
        Node temp = this.topForward;

        while ( (temp != null) 
                && temp.name.equals(buscado) == false ) {    
                 temp = temp.next;
        }

        if (temp != null){  //Nodo buscado se encontró
            temp.next = temp.next.next;
            temp.next.previous.previous = null;
            temp.next.previous.next = null;
            temp.next.previous = temp;
            temp = null;
            
            return true;
        }
        else return false;
    }
    //Método para buacar nodo por valor
     public Node buscarNodoPorValor(String valorBuscado) {
        for (Node temp = this.topForward; temp != null; temp = temp.next) {
            if (temp.name.equals(valorBuscado)) {
                return temp; // Se encontró el nodo
            }
        }
        return null; // No se encontró el nodo con el valor buscado
    }
    //Inserta un nodo nuevo después de otro (Buscado)
    public boolean insertarDespuesDeNodo(String valorBuscado, String nuevoValor) {
        Node nodoActual = buscarNodoPorValor(valorBuscado);

        if (nodoActual != null) {
            Node nuevoNodo = new Node();
            nuevoNodo.name = nuevoValor;

            nuevoNodo.next = nodoActual.next;
            nuevoNodo.previous = nodoActual;

            if (nodoActual.next != null) {
                nodoActual.next.previous = nuevoNodo;
            } else {
                // El nodo actual es el último de la lista, actualizamos topBackward
                topBackward = nuevoNodo;
            }

            nodoActual.next = nuevoNodo;

            return true; // Inserción exitosa
        }

        return false; // No se encontró el nodo con el valor buscado
    }
    //Intercambiar nodos sin importar su orden
      public boolean intercambiarNodos(String valorNodoA, String valorNodoB) {
        if (valorNodoA.equals(valorNodoB)) {
            // No es necesario intercambiar nodos si son iguales
            return false;
        }

        Node nodoA = buscarNodoPorValor(valorNodoA);
        Node nodoB = buscarNodoPorValor(valorNodoB);

        if (nodoA != null && nodoB != null) {
            // Intercambiar nodos si son encontrados

            // Actualizar enlaces de nodos anteriores
            if (nodoA.previous != null) {
                nodoA.previous.next = nodoB;
            } else {
                topForward = nodoB;
            }

            if (nodoB.previous != null) {
                nodoB.previous.next = nodoA;
            } else {
                topForward = nodoA;
            }

            // Actualizar enlaces de nodos siguientes
            if (nodoA.next != null) {
                nodoA.next.previous = nodoB;
            } else {
                topBackward = nodoB;
            }

            if (nodoB.next != null) {
                nodoB.next.previous = nodoA;
            } else {
                topBackward = nodoA;
            }

            // Intercambiar enlaces de los nodos a intercambiar
            Node temp = nodoA.next;
            nodoA.next = nodoB.next;
            nodoB.next = temp;

            temp = nodoA.previous;
            nodoA.previous = nodoB.previous;
            nodoB.previous = temp;

            return true; // Intercambio exitoso
        }
        return false; // Si alguno de los nodos no fue encontrado
    }
    
    //TODO: Crear el método para borrar el nodo buscado
    public boolean borrarNodo(String valorBuscado) {
        Node nodoActual = buscarNodoPorValor(valorBuscado);

        if (nodoActual != null) {
            // Actualizar enlaces de nodos anteriores
            if (nodoActual.previous != null) {
                nodoActual.previous.next = nodoActual.next;
            } else {
                topForward = nodoActual.next;
            }
            // Actualizar enlaces de nodos siguientes
            if (nodoActual.next != null) {
                nodoActual.next.previous = nodoActual.previous;
            } else {
                topBackward = nodoActual.previous;
            }
            // Anular el nodo actual
            nodoActual.previous = null;
            nodoActual.next = null;

            return true; // Borrado exitoso
        }
        return false; // No se encontró el nodo con el valor buscado
    }
}

