import Header from "../library/Header";
import NavigatonBar from "./NavigationBar";
import "../../css/TreatmentEditForm.css";
import { useNavigate, useParams } from "react-router-dom";
import { useState } from "react";
import { addNewTreatmentRecord} from "../../services/DoctorService";
import { Button, Form } from "react-bootstrap";
import { DOCTOR_PATIENT_TREATMENT_TABLE_ROUTE } from "../../constants/AppRouts";

const AddNewTreatment = ()=>{
    const [treatmentDetails, setTreatmentDetails] = useState({
      DoctorID: "",
      PatientID: "",
      TreatmentDetails: "",
      TreatmentDate: "",
    });
  
    const navigate = useNavigate();
  
    const handleFieldChange = (event)=>{
        setTreatmentDetails({...treatmentDetails, [event.target.name]: event.target.value})
    }
  
    const handleSubmit = (event)=>{
      event.preventDefault();
      addNewTreatmentRecord(treatmentDetails)
      .then((response) => {
        navigate(DOCTOR_PATIENT_TREATMENT_TABLE_ROUTE);
      })
      .catch((error) => {
        alert("Error");
        console.log(error);
      });
    }
    return (
      <div>
        <NavigatonBar />
        <div className="container-fluid edit-treatment-header-container">
          <Header variant="success" message="Add New treatment record data" />
        </div>
        <div className="container-fluid">
        <Form onSubmit={handleSubmit}>
            <div className="row">
              <div className="col-lg-4">
                <Form.Group className="mb-3" controlId="formBasicPassword">
                  <Form.Label>Doctor Id</Form.Label>
                  <Form.Control
                    type="text"
                    placeholder="Edit DoctorID"
                    name="DoctorID"
                    onChange={handleFieldChange}
                  />
                </Form.Group>
              </div>
              <div className="col-lg-4">
                <Form.Group className="mb-3" controlId="formBasicPassword">
                  <Form.Label>Patient Id</Form.Label>
                  <Form.Control
                    type="text"
                    placeholder="Edit Patient Id"
                    name="PatientID"
                    onChange={handleFieldChange}
                  />
                </Form.Group>
              </div>
            </div>
  
            <div className="row">
              <div className="col-lg-4">
                <Form.Group className="mb-3" controlId="formBasicPassword">
                  <Form.Label>Treatment Details</Form.Label>
                  <Form.Control
                    type="text"
                    placeholder="Edit Treatment Details"
                    name="TreatmentDetails"
                    onChange={handleFieldChange}
                  />
                </Form.Group>
              </div>
              <div className="col-lg-4">
                <Form.Group className="mb-3" controlId="formBasicPassword">
                  <Form.Label>Treatment Date</Form.Label>
                  <Form.Control
                    type="date"
                    placeholder="Edit Treatment Details"
                    name="TreatmentDate"
                    onChange={handleFieldChange}
                  />
                </Form.Group>
              </div>
            </div>
            <div className="row">
              <div className="col-lg-4">
                <Button type="submit" variant="primary">
                  Update Treatment Data
                </Button>
              </div>
            </div>
          </Form>
        </div>
      </div>
    );
}

export default AddNewTreatment;