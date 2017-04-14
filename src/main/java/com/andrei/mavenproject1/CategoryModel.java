/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrei.mavenproject1;

import com.andrei.entities.Category;
import java.util.List;
import javax.persistence.EntityManager;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author acalbaza
 */
public class CategoryModel implements TreeModel {
    private static EntityManager em;

    

    
    @Override
    public Object getRoot() {
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        Query q = session.createQuery("From Category where parentId = null ");
        List<Category> resultList = q.list();

        DefaultMutableTreeNode top =null;
        for (Category next : resultList) {
            top =  new DefaultMutableTreeNode(next);
        }
        
        //DefaultMutableTreeNode top =  new DefaultMutableTreeNode("The Java Series");
        
        session.close();
        return top;
    }

    @Override
    public Object getChild(Object parent, int index) {
        
        Category p = (Category)((DefaultMutableTreeNode)parent).getUserObject();
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        Query q = session.createQuery("From Category where parentId = :parent_id");
        
        q.setParameter("parent_id", p.getId());
        List<Category> resultList = q.list();
        int i = 0;
        DefaultMutableTreeNode child = new DefaultMutableTreeNode(resultList.get(index));
        session.close();
        return child;

    }

    @Override
    public int getChildCount(Object parent) {
        Category p = (Category)((DefaultMutableTreeNode)parent).getUserObject();
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();
        Query q = session.createQuery("From Category where parentId = :parent_id");
        
        q.setParameter("parent_id", p.getId());
        List<Category> resultList = q.list();
        session.close();
        return resultList.size();

    }

    @Override
    public boolean isLeaf(Object node) {
        if (getChildCount(node) > 0){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {
    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
