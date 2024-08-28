//import { useState } from "react"
import NavigatonBar from "./NavigationBar.jsx";
import "../../css/DoctorsPatientTreatmentsTable.css";
import { useEffect, useState } from "react";
import {
  deleteTreatmentRecord,
  fetchPatientTreatmentData,
  fetchPatientTreatmentDataWithPatientUserId,
} from "../../services/DoctorService.js";
import { Button, Table, Form, Modal, ToastContainer, Toast } from "react-bootstrap";
import { ToastNotification } from "../library/ToastNotification.jsx";
import { ModelConfirmationDialog } from "../library/ModelConfirmDialog.jsx";
import { useNavigate } from "react-router-dom";
import { EDIT_TREATMENT_TABLE_ROUTE } from "../../constants/AppRouts.js";

const DoctorsPatientTreatmentsTable = () => {
  const [treatmentData, setTreatmentData] = useState([]);
  const [patientUserId, setPatientUserId] = useState("");
  const [showModel, setShowModel] = useState(false);
  const [selectedPatientId, setSelectedPatientId] = useState(0);
  const [selectedTreatmentId, setSelectedTreatmentId] = useState(0);
  const [showToast, setShowToast] = useState(false);

  
  //const [patientDetails, setPatientDetails] = useState([]);

  const navigate = useNavigate();

  const getPatientTreatmentRecords = async () => {
    try {
      const response = await fetchPatientTreatmentData();
      const treatmentRecords = response.data;
      setTreatmentData(treatmentRecords);
    } catch (error) {
      alert('No Data found');
    }   
  };

  const getPatientRecordWithPatientUserId = async (patientUserId) => {
    try{
      const response = await fetchPatientTreatmentDataWithPatientUserId(patientUserId);
      const treatmentRecords = response.data;
      setTreatmentData(treatmentRecords);
    }catch(error){
      alert("No Data found");
    }
  };

  /*const getPatientDetials = async(patientUserId)=>{
    const response = await fetchPatientDetails(patientUserId);
    setPatientDetails(response.data);
    console.log(patientDetails);
  }*/

  const handleFetchPatientRecordWithPatientUserId = () => {
    if (patientUserId === "") {
      getPatientTreatmentRecords();
    } else {
      getPatientRecordWithPatientUserId(patientUserId);
      //getPatientDetials(patientUserId);
    }
  };

  const closeModel = () => {
    setShowModel(false);
  };

  const handleInputChange = (event) => {
    if (event.target.value === "") {
      getPatientTreatmentRecords();
    }
    setPatientUserId(event.target.value);
  };

  const handleYesClickDeleteButton = async () => {
    const response = await deleteTreatmentRecord(selectedTreatmentId);
    console.log(response);
    if (response.status === 200) {
      setShowModel(false);
      setShowToast(true);
      getPatientTreatmentRecords();
    }
  };

  const handleCloseToast =()=>{
    setShowToast(false);
  }

  useEffect(() => {
    getPatientTreatmentRecords();
  }, []);

  return (
    <div>
      <NavigatonBar />
      <div className="container-fluid doc-pat-treat-table-header p-3">
        <h1 className="doc-pat-treat-table-heading text-center">
          Patient Treatment Records
        </h1>
      </div>
      <div className="container-fluid p-3">
        <div className="row">
          <div className="col-lg-4">
            <Form.Group className="mb-3" controlId="formBasicPassword">
              <Form.Label>Search for Patient with Patient User Id</Form.Label>
              <Form.Control
                type="text"
                placeholder="Enter Patient User Id"
                name="PatientUserId"
                onChange={handleInputChange}
              />
            </Form.Group>
          </div>
          <div className="row">
            <div className="col-lg-1">
              <Button
                variant="success"
                onClick={handleFetchPatientRecordWithPatientUserId}
              >
                Search
              </Button>
            </div>
            <div className="col-lg-3">
              <Button
                variant="danger"
                onClick={()=>{
                  navigate(`/addNewTreatment`)
                }}
              >
                Add New Reocrd
              </Button>
            </div>
          </div>
        </div>
      </div>
      <div className="container-fluid mt-4">
        <Table>
          <thead>
            <tr>
              <th>Treatment Id</th>
              <th>Doctor Id</th>
              <th>Patient Id</th>
              <th>Treatment Details</th>
              <th>Treatment Date</th>
              <th>Actions</th>
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
                  <td>
                    <Button
                      variant="danger"
                      onClick={() => {
                        setShowModel(true);
                        setSelectedPatientId(eachTreatment.PatientID);
                        setSelectedTreatmentId(eachTreatment.TreatmentID);
                      }}
                    >
                      Delete
                    </Button>
                    <Button variant="primary" className="action-button-edit"
                      onClick={()=>{
                        navigate(`/editTreatmentInfo/${eachTreatment.TreatmentID}`)
                      }}
                    >
                      Edit
                    </Button>
                  </td>
                </tr>
              );
            })}
          </tbody>
        </Table>
      </div>
      <ModelConfirmationDialog 
        show={showModel} 
        message={`Are you sure, you want to delete treatment record number ${selectedTreatmentId}, for PatientID ${selectedPatientId}?`}
        onYes={handleYesClickDeleteButton}
        onClose={closeModel}
      />
      {/* <Modal show={showModel} onHide={closeModel}>
        <Modal.Header closeButton>
          <Modal.Title>Confiramtion</Modal.Title>
        </Modal.Header>
        <Modal.Body>{`Are you sure, you want to delete treatment record number ${selectedTreatmentId}, for PatientID ${selectedPatientId}?`}</Modal.Body>
        <Modal.Footer>
          <Button variant="success" onClick={handleYesClickDeleteButton}>
            Yes
          </Button>
          <Button variant="danger" onClick={closeModel}>
            No
          </Button>
        </Modal.Footer>
      </Modal> */}
      <ToastNotification background="light" 
      onClose={handleCloseToast} show={showToast} 
      message={`Treatment record ${selectedTreatmentId} removed, for PatientID ${selectedPatientId}`}/>
     {/* <ToastContainer position="top-end">
        <Toast
          onClose={handleCloseToast}
          bg="light"
          show={showToast}
          delay={5000}
          autohide
        >
          <Toast.Header>
            <strong className="me-auto">Bootstrap</strong>
          </Toast.Header>
          <Toast.Body>{`Treatment record ${selectedTreatmentId} removed, for PatientID ${selectedPatientId}?`}</Toast.Body>
        </Toast>
      </ToastContainer> */}
    </div>
  );
};

export default DoctorsPatientTreatmentsTable;
