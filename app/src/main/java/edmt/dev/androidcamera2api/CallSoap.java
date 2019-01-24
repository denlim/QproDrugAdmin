package edmt.dev.androidcamera2api;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.Objects;

public class CallSoap {
    public  final String WSDL_TARGET_NAMESPACE = "http://tempuri.org/";

    public  final String SOAP_ADDRESS = "http://192.168.80.63/SPHAIRA_LIVE_ADT/Services/testAndroid.asmx";


    public final String SOAP_ACTION_Registration = "http://tempuri.org/LoginDrugAdminApps";

    public  final String OPERATION_NAME_Registration = "LoginDrugAdminApps";

    public String LoginApps(String username, String password)
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_NAME_Registration);

        request.addProperty("username",username);
        request.addProperty("password",password);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;
        envelope.implicitTypes = true;
        envelope.encodingStyle = SoapSerializationEnvelope.XSD;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response = null;


        try
        {
            httpTransport.call(SOAP_ACTION_Registration, envelope);
            response = envelope.getResponse();
            SoapPrimitive response1 = (SoapPrimitive)envelope.getResponse();
            String data = response1.toString();
        }
        catch (Exception exception)
        {
            response=exception.toString();
        }
        return response.toString();
    }

    public final String SOAP_ACTION_RegistrationApps = "http://tempuri.org/RegisterDrugAdminApps";

    public  final String OPERATION_NAME_RegistrationApps = "RegisterDrugAdminApps";

    public String RegistrationApps(String username,String password, String parid, String sex, String dob)
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_NAME_RegistrationApps);

        request.addProperty("username",username);
        request.addProperty("password",password);
        request.addProperty("parid",parid);
        request.addProperty("sex",sex);
        request.addProperty("dob",dob);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;
        envelope.implicitTypes = true;
        envelope.encodingStyle = SoapSerializationEnvelope.XSD;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response = null;


        try
        {
            httpTransport.call(SOAP_ACTION_RegistrationApps, envelope);
            response = envelope.getResponse();
            SoapPrimitive response1 = (SoapPrimitive)envelope.getResponse();
            String data = response1.toString();
        }
        catch (Exception exception)
        {
            response=exception.toString();
        }
        return response.toString();
    }

    public final String SOAP_ACTION_Account = "http://tempuri.org/Account";

    public  final String OPERATION_NAME_Account = "Account";

    public String Account(String username)
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_NAME_Account);

        request.addProperty("username",username);


        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;
        envelope.implicitTypes = true;
        envelope.encodingStyle = SoapSerializationEnvelope.XSD;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response = null;


        try
        {
            httpTransport.call(SOAP_ACTION_Account, envelope);
            response = envelope.getResponse();
            SoapPrimitive response1 = (SoapPrimitive)envelope.getResponse();
            String data = response1.toString();
        }
        catch (Exception exception)
        {
            response=exception.toString();
        }
        return response.toString();
    }

    public final String SOAP_ACTION_Medno = "http://tempuri.org/MedicalPatient";

    public  final String OPERATION_NAME_Medno = "MedicalPatient";

    public String Medno(String username)
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_NAME_Medno);

        request.addProperty("regno",username);


        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;
        envelope.implicitTypes = true;
        envelope.encodingStyle = SoapSerializationEnvelope.XSD;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response = null;


        try
        {
            httpTransport.call(SOAP_ACTION_Medno, envelope);
            response = envelope.getResponse();
            SoapPrimitive response1 = (SoapPrimitive)envelope.getResponse();
            String data = response1.toString();
        }
        catch (Exception exception)
        {
            response=exception.toString();
        }
        return response.toString();
    }

    public final String SOAP_ACTION_MedicalAlergy = "http://tempuri.org/MedicalAlergies";

    public  final String OPERATION_NAME_MedicalAlergy = "MedicalAlergies";

    public String allergies(String username)
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_NAME_MedicalAlergy);

        request.addProperty("regno",username);


        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;
        envelope.implicitTypes = true;
        envelope.encodingStyle = SoapSerializationEnvelope.XSD;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response = null;


        try
        {
            httpTransport.call(SOAP_ACTION_MedicalAlergy, envelope);
            response = envelope.getResponse();
            SoapPrimitive response1 = (SoapPrimitive)envelope.getResponse();
            String data = response1.toString();
        }
        catch (Exception exception)
        {
            response=exception.toString();
        }
        return response.toString();
    }

    public final String SOAP_ACTION_MedicalDiagnose = "http://tempuri.org/MedicalDiagnosis";

    public  final String OPERATION_NAME_MedicalDiagnose = "MedicalDiagnosis";

    public String Diagnose(String username)
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_NAME_MedicalDiagnose);

        request.addProperty("registrationno",username);


        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;
        envelope.implicitTypes = true;
        envelope.encodingStyle = SoapSerializationEnvelope.XSD;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response = null;


        try
        {
            httpTransport.call(SOAP_ACTION_MedicalDiagnose, envelope);
            response = envelope.getResponse();
            SoapPrimitive response1 = (SoapPrimitive)envelope.getResponse();
            String data = response1.toString();
        }
        catch (Exception exception)
        {
            response=exception.toString();
        }
        return response.toString();
    }

    public final String SOAP_ACTION_MedicalProblem = "http://tempuri.org/MedicalProblem";

    public  final String OPERATION_NAME_MedicalProblem = "MedicalProblem";

    public String Problem(String username)
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_NAME_MedicalProblem);

        request.addProperty("regno",username);


        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;
        envelope.implicitTypes = true;
        envelope.encodingStyle = SoapSerializationEnvelope.XSD;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response = null;


        try
        {
            httpTransport.call(SOAP_ACTION_MedicalProblem, envelope);
            response = envelope.getResponse();
            SoapPrimitive response1 = (SoapPrimitive)envelope.getResponse();
            String data = response1.toString();
        }
        catch (Exception exception)
        {
            response=exception.toString();
        }
        return response.toString();
    }

    public final String SOAP_ACTION_PatientDetail = "http://tempuri.org/DataPasien";

    public  final String OPERATION_NAME_PatientDetail = "DataPasien";

    public String DetailPatient(String username)
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_NAME_PatientDetail);

        request.addProperty("registrationno",username);


        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;
        envelope.implicitTypes = true;
        envelope.encodingStyle = SoapSerializationEnvelope.XSD;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response = null;


        try
        {
            httpTransport.call(SOAP_ACTION_PatientDetail, envelope);
            response = envelope.getResponse();
            SoapPrimitive response1 = (SoapPrimitive)envelope.getResponse();
            String data = response1.toString();
        }
        catch (Exception exception)
        {
            response=exception.toString();
        }
        return response.toString();
    }

    public final String SOAP_ACTION_DosePatientDetail = "http://tempuri.org/ObatPasien";

    public  final String OPERATION_NAME_DosePatientDetail = "ObatPasien";

    public String DoseDetailPatient(String username,String id)
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_NAME_DosePatientDetail);

        request.addProperty("registrationno",username);
        request.addProperty("itemid",id);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;
        envelope.implicitTypes = true;
        envelope.encodingStyle = SoapSerializationEnvelope.XSD;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response = null;


        try
        {
            httpTransport.call(SOAP_ACTION_DosePatientDetail, envelope);
            response = envelope.getResponse();
            SoapPrimitive response1 = (SoapPrimitive)envelope.getResponse();
            String data = response1.toString();
        }
        catch (Exception exception)
        {
            response=exception.toString();
        }
        return response.toString();
    }

    public final String SOAP_ACTION_DosePatientUpdate = "http://tempuri.org/DrugUpdate";

    public  final String OPERATION_NAME_DosePatientDetailUpdate = "DrugUpdate";

    public String DoseDetailPatientUpdate(String regno,String itemid)
    {
        SoapObject request = new SoapObject(WSDL_TARGET_NAMESPACE,OPERATION_NAME_DosePatientDetailUpdate);

        request.addProperty("registrationno",regno);
        request.addProperty("itemid",itemid);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
                SoapEnvelope.VER11);
        envelope.dotNet = true;
        envelope.implicitTypes = true;
        envelope.encodingStyle = SoapSerializationEnvelope.XSD;

        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransport = new HttpTransportSE(SOAP_ADDRESS);
        Object response = null;


        try
        {
            httpTransport.call(SOAP_ACTION_DosePatientUpdate, envelope);
            response = envelope.getResponse();
            SoapPrimitive response1 = (SoapPrimitive)envelope.getResponse();
            String data = response1.toString();
        }
        catch (Exception exception)
        {
            response=exception.toString();
        }
        return response.toString();
    }
}
