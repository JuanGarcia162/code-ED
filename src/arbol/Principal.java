package arbol;

import javax.swing.JOptionPane;
public class Principal {
    Nodo raíz;
    public Nodo insertarRaiz(String dato) {
        raíz = new Nodo(dato);
        return raíz;
    }
    public void verHijosRecursivo(Nodo nodo) {
        //se inicia con los padres
        for (int i = 0; i < nodo.nohijos; i++) {
            nodo.hijos[i].verNodo();
            //se hace lo mismo con los nodos hijos
            verHijosRecursivo(nodo.hijos[i]);
        }
    }
    public void InsertarRecursivo(Nodo nodo, String dato, String padre) {
        Nodo nuevo = new Nodo(dato);
        //Si el padre es la raiz
        if (nodo.getDato().equals(padre)) {
            nodo.aumentarHijos(nuevo);
        } else {
            //Si el padre es alguno de los hijos
            for (int i = 0; i < nodo.nohijos; i++) {
                if (nodo.hijos[i].getDato().equals(padre)) {
                    //se coloca el hijo en el nodo
                    nodo.hijos[i].aumentarHijos(nuevo);
                } else {
                    //busca el padre en los hijos del nodo
                    InsertarRecursivo(nodo.hijos[i], dato, padre);
                }
            }
        }
    }
    public static void main(String[] args) {
        Principal arbol = new Principal();
        Nodo nodo = arbol.insertarRaiz("0");
        arbol.raíz.verNodo();
        arbol.InsertarRecursivo(nodo, "1", "0");
        arbol.InsertarRecursivo(nodo, "2", "0");
        arbol.InsertarRecursivo(nodo, "3", "0");

        arbol.InsertarRecursivo(nodo, "1.1", "1");
        arbol.InsertarRecursivo(nodo, "1.2", "1");


        arbol.InsertarRecursivo(nodo, "3.1", "3");
        arbol.InsertarRecursivo(nodo, "3.2", "3");
        arbol.InsertarRecursivo(nodo, "3.3", "3");
        arbol.InsertarRecursivo(nodo, "3.4", "3");

        arbol.InsertarRecursivo(nodo, "3.2.1", "3.2");

        String Dato, Padre = "";
        for (int i = 0; i < 0; i++) {
            Dato = JOptionPane.showInputDialog("Dato");
            Padre = JOptionPane.showInputDialog("Padre");
            arbol.InsertarRecursivo(nodo, Dato, Padre);
        }
        arbol.verHijosRecursivo(nodo);
      //Para imprimir uno por uno

    }
}