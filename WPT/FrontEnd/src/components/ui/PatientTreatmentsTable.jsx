import { useParams } from "react-router-dom";
import "../../css/PatientTreatmentTable.css";
import { useEffect, useState } from "react";
import { fetchPatientDetails, patientfetchPatientTreatmentDataWithPatientUserId } from "../../services/PatientService";
import { Alert, Table } from "react-bootstrap";
import Header from "../library/Header";

const PatientTreatmentTable = () => {
  const params = useParams();

  const [treatmentData, setTreatmentData] = useState([]);
  const [patientDetails, setPatientDetails] = useState({
    UserID: "",
    Password: "",
    FullName: "",
    DateOfBirth: "",
    Gender: "",
    Address: "",
    Phone: "",
  });

  const getPatientRecordWithPatientUserId = async (patientUserId) => {
    try {
      const response = await patientfetchPatientTreatmentDataWithPatientUserId(
        patientUserId
      );
      const treatmentRecords = response.data;
      setTreatmentData(treatmentRecords);
      await getPatientDetials(params.userId);
    } catch (error) {
        await getPatientDetials(params.userId);
      alert("No Data found");
    }
  };

  const getPatientDetials = async(patientUserId)=>{
    const response = await fetchPatientDetails(patientUserId);
    setPatientDetails(response.data[0]);
    console.log(patientDetails);
  }

  useEffect(() => {
    if (params.userId) {
      getPatientRecordWithPatientUserId(params.userId);
    }
  }, [params.userId]);

  return (
    <div className="patient-treatment-table-records p-3">
      <Header variant="success" message="Your treatment record data" />
      <Alert>
        <h1>Patient Details</h1>
        <p>{`Name:- ${patientDetails.FullName}`}</p>
        <p>{`Date of Birth:- ${Date(patientDetails.DateOfBirth).split("G")[0]}`}</p>
        <p>{`Gender:- ${patientDetails.Gender}`}</p>
        <p>{`Patient ID:- ${patientDetails.PatientID}`}</p>
        <p>{`UserID:- ${patientDetails.UserID}`}</p>
        <p>{`Phone:- ${patientDetails.Phone}`}</p>
      </Alert> 
      <h1 className="text-center">Patient Medical History</h1>
      <div className="container-fluid mt-4">
        <Table>
          <thead>
            <tr>
              <th>Treatment Id</th>
              <th>Doctor Id</th>
              <th>Patient Id</th>
              <th>Treatment Details</th>
              <th>Treatment Date</th>
            </tr>
          </thead>
          <tbody>
            {treatmentData.map((eachTreatment) => {
              return (
                <tr>
                  <td>{eachTreatment.TreatmentID}</td>
                  <td>{eachTreatment.DoctorID}</td>
                  <td>{eachTreatment.PatientID}</td>
                  <td>{eachTreatment.TreatmentDetails}</td>
                  <td>{(eachTreatment.TreatmentDate).split("T")[0]}</td>
                </tr>
              );
            })}
          </tbody>
        </Table>
      </div>
    </div>
  );
};

export default PatientTreatmentTable;
