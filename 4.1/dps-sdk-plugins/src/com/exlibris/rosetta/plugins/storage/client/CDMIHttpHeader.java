package com.exlibris.dps.repository.plugin.storage.netapp.client;

public class CDMIHttpHeader {
    /** "application/cdmi-object" */
    public static String ACCEPT = "Accept";
    /** "application/cdmi-object" */
    public static String CONTENT_TYPE = "Content-Type";
    /** A comma separated list of versions supported by the client */
    public static String CDMI_VER = "X-CDMI-Specification-Version";
    /** Indicates that the newly created object is part of a series of writes and the value has not yet been fully populated */
    public static String PARTIAL_CONTENT = "X-CDMI-Partial";
    public static String CONTENT_LENGTH = "Content-Length";

    /*
     * JSON keys
     */
    /** MIME type of the data contained within the value field of the data object */
    public static String MIMETYPE = "mimetype";
    /** The data object value */
    public static String VALUE = "value";

    public static String ACCEPT_VALUE = "application/cdmi-object";
    public static String CONTENT_TYPE_CDMI_OBJECT = "application/cdmi-object";
    public static String CDMI_VER_VALUE = "1.0.1";
    public static String PARTIAL_CONTENT_VALUE = "true";
}
