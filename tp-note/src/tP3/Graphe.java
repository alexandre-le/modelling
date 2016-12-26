/**
 */
package tP3;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Graphe</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link tP3.Graphe#getRelation <em>Relation</em>}</li>
 *   <li>{@link tP3.Graphe#getClasse <em>Classe</em>}</li>
 * </ul>
 *
 * @see tP3.TP3Package#getGraphe()
 * @model
 * @generated
 */
public interface Graphe extends EObject {
	/**
	 * Returns the value of the '<em><b>Relation</b></em>' containment reference list.
	 * The list contents are of type {@link tP3.Arc}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Relation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Relation</em>' containment reference list.
	 * @see tP3.TP3Package#getGraphe_Relation()
	 * @model containment="true"
	 * @generated
	 */
	EList<Arc> getArc();

	/**
	 * Returns the value of the '<em><b>Classe</b></em>' containment reference list.
	 * The list contents are of type {@link tP3.Sommet}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Classe</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Classe</em>' containment reference list.
	 * @see tP3.TP3Package#getGraphe_Classe()
	 * @model containment="true"
	 * @generated
	 */
	EList<Sommet> getSommet();
	EList<Sommet> getSommets();
} // Graphe
