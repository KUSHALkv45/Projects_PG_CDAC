import axios from 'axios';
import { PATIENT_DETAILS_API_ROUTE, PATIENT_LOGIN_API_ROUTE, PATIENT_TREATMENT_RECORDS_BY_PATIENT_ID_API_ROUTE, REGISTER_PATIENT_API_ROUTE, TREATMENT_RECORDS_BY_PATIENT_ID_API_ROUTE } from '../constants/ApiConstants';

export const registerPatient = (patientRegisterationData)=>{
    console.log(patientRegisterationData);
   return  axios.post(REGISTER_PATIENT_API_ROUTE, patientRegisterationData);
}

export const fetchPatientTreatmentDataWithId = ()=>{
    return axios.get(TREATMENT_RECORDS_BY_PATIENT_ID_API_ROUTE);
}

export const loginPatient = (loginDetails)=>{
    console.log(loginDetails);
    return axios.post(PATIENT_LOGIN_API_ROUTE, loginDetails);
}
export const patientfetchPatientTreatmentDataWithPatientUserId = (patientUserId) =>{
    return axios.get(`${PATIENT_TREATMENT_RECORDS_BY_PATIENT_ID_API_ROUTE}/${patientUserId}`);
}

export const fetchPatientDetails = (PatientUserId) =>{
    return axios.get(`${PATIENT_DETAILS_API_ROUTE}/${PatientUserId}`);
}