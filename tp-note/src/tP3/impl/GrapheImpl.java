/**
 */
package tP3.impl;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import tP3.Arc;
import tP3.Graphe;
import tP3.Sommet;
import tP3.TP3Package;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Graphe</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link tP3.impl.GrapheImpl#getRelation <em>Relation</em>}</li>
 *   <li>{@link tP3.impl.GrapheImpl#getClasse <em>Classe</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GrapheImpl extends MinimalEObjectImpl.Container implements Graphe {
	/**
	 * The cached value of the '{@link #getArc() <em>Relation</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArc()
	 * @generated
	 * @ordered
	 */
	protected EList<Arc> relation;

	/**
	 * The cached value of the '{@link #getSommet() <em>Classe</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSommet()
	 * @generated
	 * @ordered
	 */
	protected EList<Sommet> classe;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GrapheImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TP3Package.Literals.GRAPHE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Arc> getArc() {
		if (relation == null) {
			relation = new EObjectContainmentEList<Arc>(Arc.class, this, TP3Package.GRAPHE__RELATION);
		}
		return relation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Sommet> getSommet() {
		if (classe == null) {
			classe = new EObjectContainmentEList<Sommet>(Sommet.class, this, TP3Package.GRAPHE__CLASSE);
		}
		return classe;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TP3Package.GRAPHE__RELATION:
				return ((InternalEList<?>)getArc()).basicRemove(otherEnd, msgs);
			case TP3Package.GRAPHE__CLASSE:
				return ((InternalEList<?>)getSommet()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TP3Package.GRAPHE__RELATION:
				return getArc();
			case TP3Package.GRAPHE__CLASSE:
				return getSommet();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case TP3Package.GRAPHE__RELATION:
				getArc().clear();
				getArc().addAll((Collection<? extends Arc>)newValue);
				return;
			case TP3Package.GRAPHE__CLASSE:
				getSommet().clear();
				getSommet().addAll((Collection<? extends Sommet>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case TP3Package.GRAPHE__RELATION:
				getArc().clear();
				return;
			case TP3Package.GRAPHE__CLASSE:
				getSommet().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case TP3Package.GRAPHE__RELATION:
				return relation != null && !relation.isEmpty();
			case TP3Package.GRAPHE__CLASSE:
				return classe != null && !classe.isEmpty();
		}
		return super.eIsSet(featureID);
	}
	Graphe g;
	EList<Sommet> listSommets = null;
	public EList<Sommet> getSommets() {
		//Graphe graphe = (Graphe) resource.getContents().get(0);
		for (int i = 0; i <= g.getSommet().size() - 1; i++) {
			if (g.getSommet().get(i) instanceof Sommet) {
				listSommets.add(g.getSommet().get(i));
			}
		}
		return listSommets;
	}
} //GrapheImpl
