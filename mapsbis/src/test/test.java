package test;

import maps.Boulevard;
import maps.MapsPackage;
import maps.Pedestrian;
import maps.Square;
import maps.Street;
import maps.map;

import org.eclipse.emf.*;
import org.eclipse.emf.common.util.*;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLMapImpl;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Je charge l'instance map.xmi du méta-modèle maps.ecore
		Resource resource = chargerModele("model/map.xmi", MapsPackage.eINSTANCE);
		if (resource == null)
			System.err.println(" Erreur de chargement du modèle");

		// Instruction rÃ©cupÃ©rant le modèle sous forme d'arbre à partir de
		// la classe racine "map"
		map maMap = (map) resource.getContents().get(0);

		System.out.println(maMap.getName());
		System.out.println("-------------");

		// Get and display all streets off a given map.
		for (int i = 0; i <= maMap.getRoads().size() - 1; i++) {
			if (maMap.getRoads().get(i) instanceof Street) {
				System.out.println(maMap.getRoads().get(i).getName());
			}
		}
		System.out.println("-------------");

		// Get all pedestrian streets of a length > 1000 m.
		for (int i = 0; i <= maMap.getRoads().size() - 1; i++) {
			if (maMap.getRoads().get(i).getLength() > 1000 && maMap.getRoads().get(i) instanceof Pedestrian) {
				System.out.println(
						maMap.getRoads().get(i).getName() + " de longueur : " + maMap.getRoads().get(i).getLength());
			}
		}
		System.out.println("-------------");
		
		// For a given street name (Boulevard), get adjacent road name.
		for (int i = 0; i <= maMap.getRoads().size() - 1; i++) {
			if (maMap.getRoads().get(i) instanceof Boulevard) {
				for (int j = 0; j <= maMap.getRoads().get(i).getMeet().size() - 1; j++) {
					System.out.println(maMap.getRoads().get(i).getMeet().get(j).getName());
				}
			}
		}

		System.out.println("-------------");
		
		// For a given square name (Square), get all roads bordered by it.
		if (maMap.getSpaces().get(0) instanceof Square) {
			for (int j = 0; j <= maMap.getSpaces().get(0).getBorderedBy().size() - 1; j++) {
				System.out.println(maMap.getSpaces().get(0).getBorderedBy().get(j).getName());
			}
		}
	}

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
			System.err.println("ERREUR chargement du modÃ¨le : " + e);
			e.printStackTrace();
		}
		return resource;
	}

}
