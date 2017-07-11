package com.qaplus.utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;


/**
 * 
 */
public class XmlReaderUtil {

    private static Logger logger = LoggerFactory.getLogger(XmlReaderUtil.class);

    @SuppressWarnings("unchecked")
    public static <T> T unmarshal(String content, Class<T> clazz) {
        StringReader reader = new StringReader(content);
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmar = context.createUnmarshaller();
            T t = (T) unmar.unmarshal(reader);
            return t;
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
            reader.close();
        }
		return null;
    }

    @SuppressWarnings("unchecked")
    public static <T> T unmarshal(File file, Class<T> clazz) {
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            Unmarshaller unmar = context.createUnmarshaller();
            return (T) unmar.unmarshal(file);
        } catch (Exception e) {
        	e.printStackTrace();
        }
		return null;
    }

    @SuppressWarnings("unchecked")
    public static <T> T unmarshal(InputStream is, Class<T> clazz) {
        return unmarshal(is, clazz, false);
    }

    @SuppressWarnings("unchecked")
    public static <T> T unmarshalIgnoreNameSpace(InputStream is, Class<T> clazz) {
        return unmarshal(is, clazz, true);
    }

    @SuppressWarnings("unchecked")
    public static <T> T unmarshal(InputStream is, Class<T> clazz, boolean ignoreNameSpace) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller unmar = jaxbContext.createUnmarshaller();
            SAXParserFactory sax = SAXParserFactory.newInstance();
            if (ignoreNameSpace) {
                sax.setNamespaceAware(false);
            }
            XMLReader xmlReader = sax.newSAXParser().getXMLReader();
            Source source = new SAXSource(xmlReader, new InputSource(is));
            return (T) unmar.unmarshal(source);
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    logger.error("Close IO exception", e);
                }
            }
        }
		return null;
    }

    @SuppressWarnings("unchecked")
    public static <T> T unmarshal(String content, Class<T> clazz, boolean ignoreNameSpace) {
        StringReader reader = new StringReader(content);
        try {

            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller unmar = jaxbContext.createUnmarshaller();
            SAXParserFactory sax = SAXParserFactory.newInstance();
            if (ignoreNameSpace) {
                sax.setNamespaceAware(false);
            }
            XMLReader xmlReader = sax.newSAXParser().getXMLReader();
            Source source = new SAXSource(xmlReader, new InputSource(reader));
            T t = (T) unmar.unmarshal(source);
            return t;
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
            reader.close();
        }
		return null;
    }

    @SuppressWarnings("unchecked")
    public static <T> T unmarshal(InputStreamReader isr, Class<T> clazz, boolean ignoreNameSpace) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(clazz);
            Unmarshaller unmar = jaxbContext.createUnmarshaller();
            SAXParserFactory sax = SAXParserFactory.newInstance();
            if (ignoreNameSpace) {
                sax.setNamespaceAware(false);
            }
            XMLReader xmlReader = sax.newSAXParser().getXMLReader();
            Source source = new SAXSource(xmlReader, new InputSource(isr));
            return (T) unmar.unmarshal(source);
        } catch (Exception e) {
        	e.printStackTrace();
        } finally {
            if (isr != null) {
                try {
                    isr.close();
                } catch (IOException e) {
                    logger.error("Close IO exception", e);
                }
            }
        }
		return null;
    }

}
