package test;


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

	public void main(String[] args) {
		Resource resource = chargerModele("model/Test1.xmi", TP3Package.eINSTANCE);
		if (resource == null)
			System.err.println(" Erreur de chargement du modèle");

		Graphe g = (Graphe) resource.getContents().get(0);
		
		// Toutes les classes d'un modèle donné

		System.out.println(g.getSommet());
	}

	static TP3Factory graphe_init = null;
	static Graphe grapheG = null;
	public static Resource chargerModele(String uri, EPackage pack) {
		Resource resource = null;
		try {
			URI uriUri = URI.createURI(uri);
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("uml", new XMIResourceFactoryImpl());
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
		grapheG = graphe_init.createGraphe();
		return resource;
	}

	List<Sommet> listSommets = null;

	public List<Sommet> getSommets() {
		// Graphe graphe = (Graphe) resource.getContents().get(0);
		for (int i = 0; i <= g.getSommet().size() - 1; i++) {
			if (g.getSommet().get(i) instanceof Sommet) {
				listSommets.add(g.getSommet().get(i));
			}
		}
		return listSommets;
	}

	List<Sommet> listSuperSommets = null;
	Graphe g;
/**/
	public List<Sommet> getSuperSommets(Sommet s) {
		/*
		 * Resource resource = chargerModele("model/model2.uml",
		 * TP3Package.eINSTANCE); if (resource == null)
		 * System.err.println(" Erreur de chargement du modèle"); Graphe g =
		 * (Graphe) resource.getContents().get(0);
		 */		
		for (Sommet i : listSommets) {
			Sommet superSomm;
			for (int j = 0; j <= g.getArc().size() - 1; j++) {
				if (i.equals(s) && g.getArc().get(j).getDestination().equals(s)
						&& g.getArc().get(j).getType().equals(Type.HÉRITAGE)) {
					superSomm = g.getArc().get(j).getSource();
					listSuperSommets.add(superSomm);
				}

			}
		}
		return listSuperSommets;
	}

	// Liste des sommets par type de relation.
	List<Sommet> listAsso = null;
	List<Sommet> listAggr = null;
	List<Sommet> listComp = null;
	List<List<Sommet>> listRelation = null;
	public List<List<Sommet>> getSommetParType(Sommet s) {
		for(Sommet i:listSommets){
			for(int j =0;j<g.getArc().size();j++){
				if(i.equals(s) && g.getArc().get(j).getDestination().equals(i)){
					if(g.getArc().get(j).getType().equals(Type.ASSOCIATION)){
						listAsso.add(g.getArc().get(j).getSource());
					}
					else if(g.getArc().get(j).getType().equals(Type.AGGRÉGATION)){
						listAggr.add(g.getArc().get(j).getSource());
					}else if(g.getArc().get(j).getType().equals(Type.COMPOSITION)){
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
