import Header from "../library/Header";
import NavigatonBar from "./NavigationBar";
import "../../css/TreatmentEditForm.css";
import { useNavigate, useParams } from "react-router-dom";
import { useEffect, useState } from "react";
import { fetchTreatmentRecordByTreatmentId, updateTreamtRecordByTreatmentId } from "../../services/DoctorService";
import { LinkContainer } from "react-router-bootstrap";
import { Button, Form } from "react-bootstrap";
import { BASE_ROUTE, DOCTOR_PATIENT_TREATMENT_TABLE_ROUTE } from "../../constants/AppRouts";

const TreatmentEditForm = () => {
  const params = useParams();
  const [treatment, setTreatment] = useState({
    TreatmentID: "",
    DoctorID: "",
    PatientID: "",
    TreatmentDetails: "",
    TreatmentDate: "",
  });

  const navigate = useNavigate();
  const getTreamentRecordDetails = async () => {
    const response = await fetchTreatmentRecordByTreatmentId(
      params.TreatmentID
    );
    if (response.status === 200) {
        console.log(response.data);
      setTreatment(response.data[0]);
    }
  };
  useEffect(() => {
    getTreamentRecordDetails();
  }, []);

  const handleFieldChange = (event)=>{
        setTreatment({...treatment, [event.target.name]: event.target.value})
  }

  const handleSubmit = async(event)=>{
    event.preventDefault();
    console.log(treatment);
    const response = await updateTreamtRecordByTreatmentId(treatment);
    if(response.status === 200){
        navigate(DOCTOR_PATIENT_TREATMENT_TABLE_ROUTE);
    }
  }
  return (
    <div>
      <NavigatonBar />
      <div className="container-fluid edit-treatment-header-container">
        <Header variant="success" message="Edit treatment record data" />
      </div>
      <div className="container-fluid">
      <Form onSubmit={handleSubmit}>
          <div className="row">
            <div className="col-lg-4">
              <Form.Group className="mb-3" controlId="formBasicPassword">
                <Form.Label>Treatment Id</Form.Label>
                <Form.Control
                  type="text"
                  placeholder="Enter Treatment Id"
                  name="TreatmentID"
                  value={treatment.TreatmentID}
                  readOnly
                />
              </Form.Group>
            </div>
            <div className="col-lg-4">
              <Form.Group className="mb-3" controlId="formBasicPassword">
                <Form.Label>Doctor Id</Form.Label>
                <Form.Control
                  type="text"
                  placeholder="Edit DoctorID"
                  name="DoctorID"
                  value={treatment.DoctorID}
                  onChange={handleFieldChange}
                  readOnly
                />
              </Form.Group>
            </div>
          </div>

          <div className="row">
            <div className="col-lg-4">
              <Form.Group className="mb-3" controlId="formBasicPassword">
                <Form.Label>Patient Id</Form.Label>
                <Form.Control
                  type="text"
                  placeholder="Edit Patient Id"
                  name="PatientID"
                  value={treatment.PatientID}
                  onChange={handleFieldChange}
                />
              </Form.Group>
            </div>
            <div className="col-lg-4">
              <Form.Group className="mb-3" controlId="formBasicPassword">
                <Form.Label>Treatment Details</Form.Label>
                <Form.Control
                  type="text"
                  placeholder="Edit Treatment Details"
                  name="TreatmentDetails"
                  value={treatment.TreatmentDetails}
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
};

export default TreatmentEditForm;
