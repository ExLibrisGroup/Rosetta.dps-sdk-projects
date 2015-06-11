package com.exlibris.dps.repository.plugin.storage.netapp.client;

public class CDMIResponseStatus {
	/** The request has succeeded. */
    public static int OK = 200;

    /** Resource created successfully */
    public static int Created = 201;

    /** Long running operation accepted for processing */
    public static int Accepted = 202;

    /** Operation successful, no data */
    public static int No_Content = 204;

    /** Missing or invalid request contents */
    public static int Bad_Request = 400;

    /** Invalid authentication/authorization credentials */
    public static int Unauthorized = 401;

    /** This user is not allowed to perform this request */
    public static int Forbidden = 403;

    /** A resource was not found at the specified URI. */
    public static int Not_Found = 404;

    /** Requested HTTP verb not allowed on this resource */
    public static int Method_Not_Allowed = 405;

    /** No content type can be produced at this URI that matches the request */
    public static int Not_Acceptable = 406;

    /** The operation conflicts with a non-CDMI access protocol lock, or could cause a state transition error on the server. */
    public static int Conflict = 409;

    /** An unexpected vendor specific error */
    public static int Internal_Server_Error = 500;

    /** A CDMI operation or metadata value was attempted
     * that is not implemented */
    public static int Not_Implemented = 501;
}
