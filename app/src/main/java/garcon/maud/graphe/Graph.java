package garcon.maud.graphe;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Maud Garçon & Saly Knab
 */

public class Graph {
    //Liste des noeuds du graphe
    private ArrayList<Node> noeuds;
    //Liste des arcs du graphe
    private ArrayList<Arc> arcs;

    //Constructeur de Graph
    public Graph(int n) {
        //n = nombre de noeud
        //initialisation du liste de noeuds
        noeuds = new ArrayList<>();
        for (int i = 0; i < n; i++){
            //intialisations des noeuds
            noeuds.add(new Node(120 * i,0, "noir", String.valueOf(i), 100));
        }

        //initialisation liste arc
        arcs = new ArrayList<>();
    }

    // Getter et setter ----------------------------------------------

    public ArrayList<Arc> getArcs() {
        return arcs;
    }

    public void setArcs(ArrayList<Arc> arcs) {
        this.arcs = arcs;
    }

    public ArrayList<Node> getNoeuds() {
        return noeuds;
    }

    public void setNoeuds(ArrayList<Node> noeuds) {
        this.noeuds = noeuds;
    }

    //---------------------------------------------------------------

    /**
     * Ajouter un noeud dans le graphe
     * TODO : unicité des noms
     */
    public void ajouterNoeud(){
        noeuds.add(new Node( 300,300, "noir", "0", 100));
    }

    /**
     * Ajouter un arc entre 2 noeuds
     * @param nd noeud depart
     * @param na noeud arrivé
     */
    public void ajouterArc(Node nd, Node na){
        if (nd != null && na != null){
            arcs.add(new Arc(nd, na,"1"));
        }
    }

    /**
     * Supprimer un noeud et les arcs associés
     * @param noeud
     */
    public void supprimerNoeud(Node noeud){
        //supprime le noeud
        noeuds.remove(noeud);
        Iterator<Arc> i = arcs.iterator();
        while (i.hasNext()){
            Arc arc = i.next();
            if (arc.getNoeudDepart() == noeud || arc.getNoeudArrive() == noeud){
                //supprime l'arc
                i.remove();
            }
        }
    }
}

