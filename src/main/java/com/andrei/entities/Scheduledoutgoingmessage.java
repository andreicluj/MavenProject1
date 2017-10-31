/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.andrei.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author acalbaza
 */
@Entity
@Table(name = "SCHEDULEDOUTGOINGMESSAGE")
@SequenceGenerator(initialValue = 1, name = "idgen", sequenceName = "seq_global")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Scheduledoutgoingmessage.findAll", query = "SELECT s FROM Scheduledoutgoingmessage s")
    , @NamedQuery(name = "Scheduledoutgoingmessage.findById", query = "SELECT s FROM Scheduledoutgoingmessage s WHERE s.id = :id")
    , @NamedQuery(name = "Scheduledoutgoingmessage.findByCreationtime", query = "SELECT s FROM Scheduledoutgoingmessage s WHERE s.creationtime = :creationtime")
    , @NamedQuery(name = "Scheduledoutgoingmessage.findByAdditionaltext", query = "SELECT s FROM Scheduledoutgoingmessage s WHERE s.additionaltext = :additionaltext")
    , @NamedQuery(name = "Scheduledoutgoingmessage.findByActive", query = "SELECT s FROM Scheduledoutgoingmessage s WHERE s.active = :active")
    , @NamedQuery(name = "Scheduledoutgoingmessage.findByRevision", query = "SELECT s FROM Scheduledoutgoingmessage s WHERE s.revision = :revision")})
public class Scheduledoutgoingmessage implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "idgen")   
    @Column(name = "ID")
    private Long id;
    @Basic(optional = false)
    @Column(name = "CREATIONTIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationtime;
    @Lob
    @Column(name = "ORIGINALMESSAGE")
    private String originalmessage;
    @Column(name = "ADDITIONALTEXT")
    private String additionaltext;
    @Basic(optional = false)
    @Column(name = "ACTIVE")
    private short active;
    @Basic(optional = false)
    @Column(name = "REVISION")
    private long revision;

    public Scheduledoutgoingmessage() {
    }

    public Scheduledoutgoingmessage(Long id) {
        this.id = id;
    }

    public Scheduledoutgoingmessage(Long id, Date creationtime, short active, long revision) {
        this.id = id;
        this.creationtime = creationtime;
        this.active = active;
        this.revision = revision;
    }
    
    public Scheduledoutgoingmessage(Date creationtime, short active, long revision) {
        this.creationtime = creationtime;
        this.active = active;
        this.revision = revision;
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreationtime() {
        return creationtime;
    }

    public void setCreationtime(Date creationtime) {
        this.creationtime = creationtime;
    }

    public String getOriginalmessage() {
        return originalmessage;
    }

    public void setOriginalmessage(String originalmessage) {
        this.originalmessage = originalmessage;
    }

    public String getAdditionaltext() {
        return additionaltext;
    }

    public void setAdditionaltext(String additionaltext) {
        this.additionaltext = additionaltext;
    }

    public short getActive() {
        return active;
    }

    public void setActive(short active) {
        this.active = active;
    }

    public long getRevision() {
        return revision;
    }

    public void setRevision(long revision) {
        this.revision = revision;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Scheduledoutgoingmessage)) {
            return false;
        }
        Scheduledoutgoingmessage other = (Scheduledoutgoingmessage) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.andrei.entities.Scheduledoutgoingmessage[ id=" + id + " ]";
    }
    
}
