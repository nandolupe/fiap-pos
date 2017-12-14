/*
 * Generated by JasperReports - 28/02/15 12:07
 */
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.fill.*;

import java.util.*;
import java.math.*;
import java.text.*;
import java.io.*;
import java.net.*;

import net.sf.jasperreports.engine.*;
import java.util.*;
import net.sf.jasperreports.engine.data.*;


/**
 *
 */
public class teste_1425136076407_276084 extends JREvaluator
{


    /**
     *
     */
    private JRFillParameter parameter_REPORT_LOCALE = null;
    private JRFillParameter parameter_REPORT_VIRTUALIZER = null;
    private JRFillParameter parameter_REPORT_TIME_ZONE = null;
    private JRFillParameter parameter_REPORT_FILE_RESOLVER = null;
    private JRFillParameter parameter_REPORT_SCRIPTLET = null;
    private JRFillParameter parameter_REPORT_PARAMETERS_MAP = null;
    private JRFillParameter parameter_REPORT_CONNECTION = null;
    private JRFillParameter parameter_REPORT_CLASS_LOADER = null;
    private JRFillParameter parameter_REPORT_DATA_SOURCE = null;
    private JRFillParameter parameter_REPORT_URL_HANDLER_FACTORY = null;
    private JRFillParameter parameter_IS_IGNORE_PAGINATION = null;
    private JRFillParameter parameter_REPORT_FORMAT_FACTORY = null;
    private JRFillParameter parameter_REPORT_MAX_COUNT = null;
    private JRFillParameter parameter_REPORT_TEMPLATES = null;
    private JRFillParameter parameter_REPORT_RESOURCE_BUNDLE = null;
    private JRFillField field_numeroControle = null;
    private JRFillField field_dataGeracao = null;
    private JRFillField field_nomeCurso = null;
    private JRFillField field_nome = null;
    private JRFillField field_resumoDisciplina = null;
    private JRFillField field_nomeDisciplina = null;
    private JRFillField field_caminhoLogo = null;
    private JRFillField field_matricula = null;
    private JRFillVariable variable_PAGE_NUMBER = null;
    private JRFillVariable variable_COLUMN_NUMBER = null;
    private JRFillVariable variable_REPORT_COUNT = null;
    private JRFillVariable variable_PAGE_COUNT = null;
    private JRFillVariable variable_COLUMN_COUNT = null;


    /**
     *
     */
    public void customizedInit(
        Map pm,
        Map fm,
        Map vm
        )
    {
        initParams(pm);
        initFields(fm);
        initVars(vm);
    }


    /**
     *
     */
    private void initParams(Map pm)
    {
        parameter_REPORT_LOCALE = (JRFillParameter)pm.get("REPORT_LOCALE");
        parameter_REPORT_VIRTUALIZER = (JRFillParameter)pm.get("REPORT_VIRTUALIZER");
        parameter_REPORT_TIME_ZONE = (JRFillParameter)pm.get("REPORT_TIME_ZONE");
        parameter_REPORT_FILE_RESOLVER = (JRFillParameter)pm.get("REPORT_FILE_RESOLVER");
        parameter_REPORT_SCRIPTLET = (JRFillParameter)pm.get("REPORT_SCRIPTLET");
        parameter_REPORT_PARAMETERS_MAP = (JRFillParameter)pm.get("REPORT_PARAMETERS_MAP");
        parameter_REPORT_CONNECTION = (JRFillParameter)pm.get("REPORT_CONNECTION");
        parameter_REPORT_CLASS_LOADER = (JRFillParameter)pm.get("REPORT_CLASS_LOADER");
        parameter_REPORT_DATA_SOURCE = (JRFillParameter)pm.get("REPORT_DATA_SOURCE");
        parameter_REPORT_URL_HANDLER_FACTORY = (JRFillParameter)pm.get("REPORT_URL_HANDLER_FACTORY");
        parameter_IS_IGNORE_PAGINATION = (JRFillParameter)pm.get("IS_IGNORE_PAGINATION");
        parameter_REPORT_FORMAT_FACTORY = (JRFillParameter)pm.get("REPORT_FORMAT_FACTORY");
        parameter_REPORT_MAX_COUNT = (JRFillParameter)pm.get("REPORT_MAX_COUNT");
        parameter_REPORT_TEMPLATES = (JRFillParameter)pm.get("REPORT_TEMPLATES");
        parameter_REPORT_RESOURCE_BUNDLE = (JRFillParameter)pm.get("REPORT_RESOURCE_BUNDLE");
    }


    /**
     *
     */
    private void initFields(Map fm)
    {
        field_numeroControle = (JRFillField)fm.get("numeroControle");
        field_dataGeracao = (JRFillField)fm.get("dataGeracao");
        field_nomeCurso = (JRFillField)fm.get("nomeCurso");
        field_nome = (JRFillField)fm.get("nome");
        field_resumoDisciplina = (JRFillField)fm.get("resumoDisciplina");
        field_nomeDisciplina = (JRFillField)fm.get("nomeDisciplina");
        field_caminhoLogo = (JRFillField)fm.get("caminhoLogo");
        field_matricula = (JRFillField)fm.get("matricula");
    }


    /**
     *
     */
    private void initVars(Map vm)
    {
        variable_PAGE_NUMBER = (JRFillVariable)vm.get("PAGE_NUMBER");
        variable_COLUMN_NUMBER = (JRFillVariable)vm.get("COLUMN_NUMBER");
        variable_REPORT_COUNT = (JRFillVariable)vm.get("REPORT_COUNT");
        variable_PAGE_COUNT = (JRFillVariable)vm.get("PAGE_COUNT");
        variable_COLUMN_COUNT = (JRFillVariable)vm.get("COLUMN_COUNT");
    }


    /**
     *
     */
    public Object evaluate(int id) throws Throwable
    {
        Object value = null;

        switch (id)
        {
            case 0 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=0$
                break;
            }
            case 1 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=1$
                break;
            }
            case 2 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=2$
                break;
            }
            case 3 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=3$
                break;
            }
            case 4 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=4$
                break;
            }
            case 5 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=5$
                break;
            }
            case 6 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=6$
                break;
            }
            case 7 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=7$
                break;
            }
            case 8 : 
            {
                value = (java.lang.String)(((java.lang.String)field_caminhoLogo.getValue()));//$JR_EXPR_ID=8$
                break;
            }
            case 9 : 
            {
                value = (java.awt.Image)(it.businesslogic.ireport.barcode.BcImage.getBarcodeImage(13,((java.lang.String)field_numeroControle.getValue()),false,false,null,0,0));//$JR_EXPR_ID=9$
                break;
            }
            case 10 : 
            {
                value = (java.lang.String)("Data Gera��o: "+((java.lang.String)field_dataGeracao.getValue()));//$JR_EXPR_ID=10$
                break;
            }
            case 11 : 
            {
                value = (java.lang.String)(((java.lang.String)field_dataGeracao.getValue()));//$JR_EXPR_ID=11$
                break;
            }
            case 12 : 
            {
                value = (java.lang.String)(((java.lang.String)field_nomeCurso.getValue()));//$JR_EXPR_ID=12$
                break;
            }
            case 13 : 
            {
                value = (java.lang.String)(((net.sf.jasperreports.engine.data.JRXmlDataSource)((net.sf.jasperreports.engine.JRDataSource)parameter_REPORT_DATA_SOURCE.getValue())).dataSource("/report/data/file"));//$JR_EXPR_ID=13$
                break;
            }
            case 14 : 
            {
                value = (java.lang.String)(((java.lang.String)field_nome.getValue()));//$JR_EXPR_ID=14$
                break;
            }
            case 15 : 
            {
                value = (java.lang.String)(((java.lang.String)field_matricula.getValue()));//$JR_EXPR_ID=15$
                break;
            }
            case 16 : 
            {
                value = (java.lang.String)("Total de alunos: "+((java.lang.Integer)variable_REPORT_COUNT.getValue()));//$JR_EXPR_ID=16$
                break;
            }
           default :
           {
           }
        }
        
        return value;
    }


    /**
     *
     */
    public Object evaluateOld(int id) throws Throwable
    {
        Object value = null;

        switch (id)
        {
            case 0 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=0$
                break;
            }
            case 1 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=1$
                break;
            }
            case 2 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=2$
                break;
            }
            case 3 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=3$
                break;
            }
            case 4 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=4$
                break;
            }
            case 5 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=5$
                break;
            }
            case 6 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=6$
                break;
            }
            case 7 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=7$
                break;
            }
            case 8 : 
            {
                value = (java.lang.String)(((java.lang.String)field_caminhoLogo.getOldValue()));//$JR_EXPR_ID=8$
                break;
            }
            case 9 : 
            {
                value = (java.awt.Image)(it.businesslogic.ireport.barcode.BcImage.getBarcodeImage(13,((java.lang.String)field_numeroControle.getOldValue()),false,false,null,0,0));//$JR_EXPR_ID=9$
                break;
            }
            case 10 : 
            {
                value = (java.lang.String)("Data Gera��o: "+((java.lang.String)field_dataGeracao.getOldValue()));//$JR_EXPR_ID=10$
                break;
            }
            case 11 : 
            {
                value = (java.lang.String)(((java.lang.String)field_dataGeracao.getOldValue()));//$JR_EXPR_ID=11$
                break;
            }
            case 12 : 
            {
                value = (java.lang.String)(((java.lang.String)field_nomeCurso.getOldValue()));//$JR_EXPR_ID=12$
                break;
            }
            case 13 : 
            {
                value = (java.lang.String)(((net.sf.jasperreports.engine.data.JRXmlDataSource)((net.sf.jasperreports.engine.JRDataSource)parameter_REPORT_DATA_SOURCE.getValue())).dataSource("/report/data/file"));//$JR_EXPR_ID=13$
                break;
            }
            case 14 : 
            {
                value = (java.lang.String)(((java.lang.String)field_nome.getOldValue()));//$JR_EXPR_ID=14$
                break;
            }
            case 15 : 
            {
                value = (java.lang.String)(((java.lang.String)field_matricula.getOldValue()));//$JR_EXPR_ID=15$
                break;
            }
            case 16 : 
            {
                value = (java.lang.String)("Total de alunos: "+((java.lang.Integer)variable_REPORT_COUNT.getOldValue()));//$JR_EXPR_ID=16$
                break;
            }
           default :
           {
           }
        }
        
        return value;
    }


    /**
     *
     */
    public Object evaluateEstimated(int id) throws Throwable
    {
        Object value = null;

        switch (id)
        {
            case 0 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=0$
                break;
            }
            case 1 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=1$
                break;
            }
            case 2 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=2$
                break;
            }
            case 3 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=3$
                break;
            }
            case 4 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=4$
                break;
            }
            case 5 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=5$
                break;
            }
            case 6 : 
            {
                value = (java.lang.Integer)(new Integer(1));//$JR_EXPR_ID=6$
                break;
            }
            case 7 : 
            {
                value = (java.lang.Integer)(new Integer(0));//$JR_EXPR_ID=7$
                break;
            }
            case 8 : 
            {
                value = (java.lang.String)(((java.lang.String)field_caminhoLogo.getValue()));//$JR_EXPR_ID=8$
                break;
            }
            case 9 : 
            {
                value = (java.awt.Image)(it.businesslogic.ireport.barcode.BcImage.getBarcodeImage(13,((java.lang.String)field_numeroControle.getValue()),false,false,null,0,0));//$JR_EXPR_ID=9$
                break;
            }
            case 10 : 
            {
                value = (java.lang.String)("Data Gera��o: "+((java.lang.String)field_dataGeracao.getValue()));//$JR_EXPR_ID=10$
                break;
            }
            case 11 : 
            {
                value = (java.lang.String)(((java.lang.String)field_dataGeracao.getValue()));//$JR_EXPR_ID=11$
                break;
            }
            case 12 : 
            {
                value = (java.lang.String)(((java.lang.String)field_nomeCurso.getValue()));//$JR_EXPR_ID=12$
                break;
            }
            case 13 : 
            {
                value = (java.lang.String)(((net.sf.jasperreports.engine.data.JRXmlDataSource)((net.sf.jasperreports.engine.JRDataSource)parameter_REPORT_DATA_SOURCE.getValue())).dataSource("/report/data/file"));//$JR_EXPR_ID=13$
                break;
            }
            case 14 : 
            {
                value = (java.lang.String)(((java.lang.String)field_nome.getValue()));//$JR_EXPR_ID=14$
                break;
            }
            case 15 : 
            {
                value = (java.lang.String)(((java.lang.String)field_matricula.getValue()));//$JR_EXPR_ID=15$
                break;
            }
            case 16 : 
            {
                value = (java.lang.String)("Total de alunos: "+((java.lang.Integer)variable_REPORT_COUNT.getEstimatedValue()));//$JR_EXPR_ID=16$
                break;
            }
           default :
           {
           }
        }
        
        return value;
    }


}
