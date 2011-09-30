/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masasdani.pemira.report;

import com.masasdani.pemira.HibernateUtil;
import com.masasdani.pemira.dao.MahasiswaDao;
import com.masasdani.pemira.entity.Mahasiswa;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author badak
 */
public class CetakLaporan {

    public CetakLaporan(List<Mahasiswa> list) {
        InputStream inputStream = null;
        try {
            inputStream = JRLoader.getResourceInputStream("com/masasdani/pemira/report/report2.jasper");
            MahasiswaDao mahasiswaDao=HibernateUtil.getMahasiswaDao();
            //List<Mahasiswa> list=mahasiswaDao.getAll();
            JRDataSource dataSource= new JRBeanCollectionDataSource(list);
            Map<Object, Object> map= new HashMap<Object, Object>();
            map.put(JRParameter.REPORT_DATA_SOURCE, dataSource);
            JasperPrint jasperPrint=JasperFillManager.fillReport(inputStream, map);
            JasperViewer.viewReport(jasperPrint);
        } catch (JRException ex) {
            Logger.getLogger(CetakLaporan.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                inputStream.close();
            } catch (IOException ex) {
                Logger.getLogger(CetakLaporan.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
