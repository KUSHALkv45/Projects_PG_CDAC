import axios from 'axios';
import { ADD_NEW_TREATMENT_DETAILS_API_ROUTE, DELETE_TREATMENT_RECORD_API_ROUTE, DOCTOR_LOGIN_API_ROUTE, GET_ALL_TREATMENT_RECORDS_API_ROUTE, PATIENT_DETAILS_API_ROUTE, REGISTER_DOCTOR_API_ROUTE, TREATMENT_RECORDS_BY_PATIENT_ID_API_ROUTE, TREATMENT_TABLE_ROUTE } from '../constants/ApiConstants';

export const registerDoctor = (doctorRegisterationData)=>{
    console.log(doctorRegisterationData);
   return  axios.post(REGISTER_DOCTOR_API_ROUTE, doctorRegisterationData);
}

export const fetchPatientTreatmentData = ()=>{
    return axios.get(GET_ALL_TREATMENT_RECORDS_API_ROUTE);
}

export const fetchPatientTreatmentDataWithPatientUserId = (patientUserId) =>{
    return axios.get(`${TREATMENT_RECORDS_BY_PATIENT_ID_API_ROUTE}/${patientUserId}`);
}

export const fetchPatientDetails = (PatientUserId) =>{
    return axios.get(`${PATIENT_DETAILS_API_ROUTE}/${PatientUserId}`);
}

export const deleteTreatmentRecord = (treatmentId)=>{
    return axios.delete(`${DELETE_TREATMENT_RECORD_API_ROUTE}/${treatmentId}`);
}

export const fetchTreatmentRecordByTreatmentId = (TreatmentID)=>{
    return axios.get(`${TREATMENT_TABLE_ROUTE}/${TreatmentID}`);
}

export const updateTreamtRecordByTreatmentId = (treatmentData)=>{
    return axios.put(`${TREATMENT_TABLE_ROUTE}/${treatmentData.TreatmentID}`, treatmentData);
}

export const addNewTreatmentRecord = (treatmentDetails) =>{
    return axios.post(ADD_NEW_TREATMENT_DETAILS_API_ROUTE, treatmentDetails);
}

export const loginDoctor = (loginDetails)=>{
    return axios.post(DOCTOR_LOGIN_API_ROUTE, loginDetails);
}