package test;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.*;
import org.eclipse.emf.common.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLMapImpl;

import org.eclipse.uml2.uml.Element;
import org.eclipse.uml2.uml.ElementImport;
import org.eclipse.uml2.uml.Model;
import org.eclipse.uml2.uml.Package;
import org.eclipse.uml2.uml.PackageableElement;
import org.eclipse.uml2.uml.Parameter;
import org.eclipse.uml2.uml.ParameterDirectionKind;
import org.eclipse.uml2.uml.UMLFactory;
import org.eclipse.uml2.uml.UMLPackage;
import org.eclipse.uml2.uml.VisibilityKind;
import org.eclipse.uml2.uml.resource.XMI2UMLResource.Factory;

import tP3.Arc;
import tP3.Graphe;
import tP3.Sommet;
import tP3.TP3Factory;
import tP3.TP3Package;
import tP3.Type;

import org.eclipse.uml2.uml.Class;
import org.eclipse.uml2.uml.Property;
import org.eclipse.uml2.uml.Operation;

public class test {

	public static void main(String[] args) {
		// Chargement du modèle Test2
		Resource resource = chargerModele("model/Test2.xmi", TP3Package.eINSTANCE);
		if (resource == null)
			System.err.println(" Erreur de chargement du modèle");

		Graphe g = (Graphe) resource.getContents().get(0);

		// Liste des sommets du modèle Test2
		System.out.println("Liste des sommets du modèle Test2 : " + getAllSommets(g));

		
		for(int i = 0;i<g.getArc().size();i++){
			System.out.println(g.getArc().get(i).getType().toString()+" Source : " + g.getArc().get(i).getSource().toString() + " Destination : "+ g.getArc().get(i).getDestination().toString());
		}
		
		
		System.out.println(getSuperSommets(g.getSommet().get(0), g));
		//System.out.println(g.getArc().get(1).getDestination());
		//System.out.println(getSuperSommets(g.getSommet().get(1)));
		Resource resource3 = chargerModele("model/Test3.xmi", TP3Package.eINSTANCE);
		if (resource3 == null)
			System.err.println(" Erreur de chargement du modèle");
		Graphe g3=(Graphe) resource3.getContents().get(0);
		System.out.println("Liste des sommets du modèle Test3 : " + getAllSommets(g3));
		
	}

	static TP3Factory graphe_init = null;
	static Graphe grapheG = null;

	public static Resource chargerModele(String uri, EPackage pack) {
		Resource resource = null;
		try {
			URI uriUri = URI.createURI(uri);
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
			resource = (new ResourceSetImpl()).createResource(uriUri);
			XMLResource.XMLMap xmlMap = new XMLMapImpl();
			xmlMap.setNoNamespacePackage(pack);
			java.util.Map options = new java.util.HashMap();
			options.put(XMLResource.OPTION_XML_MAP, xmlMap);
			resource.load(options);
		} catch (Exception e) {
			System.err.println("ERREUR chargement du modèle : " + e);
			e.printStackTrace();
		}
		//grapheG = graphe_init.createGraphe();
		return resource;
	}
	
	//static ArrayList<String> listS = new ArrayList<String>();
	
	// Renvoie la liste des sommets dans un tableau de chaînes de caractères
	public static ArrayList<String> getAllSommets(Graphe graph){
		ArrayList<String> listSummit = new ArrayList<String>();
		for(int i=0;i<graph.getSommet().size();i++){
			listSummit.add(graph.getSommet().get(i).getName());
		}
		return listSummit;
	}

	// List<Sommet> listSommets = null;
	static List<Sommet> listSommets = new ArrayList<Sommet>();

	public static List<Sommet> getSommets(Graphe g) {
		List<Sommet> listSommets = new ArrayList<Sommet>();
		for (int i = 0; i <= g.getSommet().size() - 1; i++) {
			if (g.getSommet().get(i) instanceof Sommet) {
				listSommets.add(g.getSommet().get(i));
			}
		}
		return listSommets;
	}

	static Graphe g;

	/**/
	public static List<Sommet> getSuperSommets(Sommet s,Graphe g) {
		List<Sommet> listSuperSommets = new ArrayList<Sommet>();
			for (int j = 0; j <= g.getArc().size() - 1; j++) {
				// A changer : ASSOCIATION par HERITAGE 
				if (g.getArc().get(j).getDestination().equals(s) && g.getArc().get(j).getType().equals(Type.ASSOCIATION)) {
						listSuperSommets.add(g.getArc().get(j).getSource());
					}
			}
			return listSuperSommets;
	}
		
	

	// Liste des sommets par type de relation.
	

	public static List<List<Sommet>> getSommetParType(Sommet s) {
		List<Sommet> listAsso = new ArrayList<Sommet>();
		List<Sommet> listAggr = new ArrayList<Sommet>();
		List<Sommet> listComp = new ArrayList<Sommet>();
		List<List<Sommet>> listRelation = new ArrayList<List<Sommet>>();
		for (Sommet i : listSommets) {
			for (int j = 0; j < g.getArc().size(); j++) {
				if (i.equals(s) && g.getArc().get(j).getDestination().equals(i)) {
					if (g.getArc().get(j).getType().equals(Type.ASSOCIATION)) {
						listAsso.add(g.getArc().get(j).getSource());
					} else if (g.getArc().get(j).getType().equals(Type.AGGRÉGATION)) {
						listAggr.add(g.getArc().get(j).getSource());
					} else if (g.getArc().get(j).getType().equals(Type.COMPOSITION)) {
						listComp.add(g.getArc().get(j).getSource());
					}
				}
				listRelation.add(listAsso);
				listRelation.add(listAggr);
				listRelation.add(listComp);
			}
		}
		return listRelation;
	}

	// Construction sommets
	public Graphe constructionSommetGraphe() {
		if (grapheG.equals(null)) {
			for (Sommet i : listSommets) {
				grapheG.getSommet().add(i);
			}
		}
		return grapheG;
	}

	// Construction arcs
	public Graphe constructionArcGraphe() {
		for (Sommet i : listSommets) {
			if (i.getArcAssocie()) {

			}
		}
		return null;
	}
}
