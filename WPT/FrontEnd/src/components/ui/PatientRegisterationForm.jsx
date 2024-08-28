import { useState } from "react";
import { Button, Form, Toast, ToastContainer } from "react-bootstrap";
import { BASE_ROUTE, PATIENT_LOGIN_ROUTE } from "../../constants/AppRouts";
import { LinkContainer } from "react-router-bootstrap";
import "../../css/RegistrationForm.css";
import NavigatonBar from "./NavigationBar";
import { registerPatient } from "../../services/PatientService";
import { ToastNotification } from "../library/ToastNotification";
import PatientRegistrationValidation from "../../services/PatientRegistrationValidation";
import { Link } from "react-router-dom";

const PatientRegistrationForm = () => {
  const [patientFormData, setPatientFormData] = useState({
    UserID: "",
    Password: "",
    FullName: "",
    DateOfBirth: "",
    Gender: "",
    Address: "",
    Phone: "",
    confirmPassword: "",
  });
  const [errors, setErrors] = useState({});

  const [showToast, setShowToast] = useState(false);
  const [respnseStatus, setResponseStatus] = useState("");

  const handleFieldChange = (event) => {
    console.log(event.target.value);
    setPatientFormData({
      ...patientFormData,
      [event.target.name]: event.target.value,
    });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    const validationErrors = PatientRegistrationValidation(patientFormData);
    setErrors(validationErrors);
    console.log(patientFormData);
    if (
      errors.UserID === "" &&
      errors.FullName === "" &&
      errors.Password === "" &&
      errors.confirmPassword === "" &&
      errors.Gender === "" &&
      errors.DateOfBirth === "" &&
      errors.Address === "" &&
      errors.Phone === ""
    ) {
      console.log(patientFormData);
      registerPatient(patientFormData)
        .then((response) => {
          setResponseStatus(response.data.message);
          setShowToast(true);
        })
        .catch((error) => {
          alert("User already exists");
          console.log(error);
        });
    }
  };

  const handleCloseToast = () => {
    setShowToast(false);
  };
  return (
    <div>
      <div className="d-flex justify-content-center align-items-center vh-100 back-g background">
        <div className="bg-white p-4 rounded w-50 in-form mt-5">
          <h2 className="text-center text">Patient's Registration</h2>
          <form className="r-form " onSubmit={handleSubmit}>
            <div className="row r1">
              <div className="col-md-6 mb-3">
                <label htmlFor="UserID">
                  <strong>User ID</strong>
                </label>
                <input
                  type="text"
                  placeholder="Enter User ID"
                  name="UserID"
                  onChange={handleFieldChange}
                  className="form-control rounded-0"
                ></input>
                {errors.UserID && (
                  <span className="text-danger">{errors.UserID}</span>
                )}
              </div>
              <div className="col-md-6 mb-3">
                <label htmlFor="FullName">
                  <strong>Full Name</strong>
                </label>
                <input
                  type="text"
                  placeholder="Enter Full Name"
                  name="FullName"
                  onChange={handleFieldChange}
                  className="form-control rounded-0"
                ></input>
                {errors.FullName && (
                  <span className="text-danger">{errors.FullName}</span>
                )}
              </div>
            </div>
            <div className="row">
              <div className="col-md-6 mb-3">
                <label htmlFor="Password">
                  <strong>Password</strong>
                </label>
                <input
                  type="password"
                  placeholder="Enter Password"
                  name="Password"
                  onChange={handleFieldChange}
                  className="form-control rounded-0"
                ></input>
                {errors.Password && (
                  <span className="text-danger">{errors.Password}</span>
                )}
              </div>
              <div className="col-md-6 mb-3">
                <label htmlFor="confirmPassword">
                  <strong>Confirm Password</strong>
                </label>
                <input
                  type="password"
                  placeholder="Confirm Password"
                  name="confirmPassword"
                  onChange={handleFieldChange}
                  className="form-control rounded-0"
                ></input>
                {errors.confirmPassword && (
                  <span className="text-danger">{errors.confirmPassword}</span>
                )}
              </div>
            </div>
            <div className="row">
              <div className="col-md-6 mb-3">
                <label htmlFor="Gender">
                  <strong>Gender</strong>
                </label>
                <select
                  name="Gender"
                  onChange={handleFieldChange}
                  className="form-control rounded-0"
                >
                  <option value="">Select Gender</option>
                  <option value="male">Male</option>
                  <option value="female">Female</option>
                  <option value="other">Other</option>
                </select>
                {errors.Gender && (
                  <span className="text-danger">{errors.Gender}</span>
                )}
              </div>

              <div className="col-md-6 mb-3">
                <label htmlFor="DateOfBirth">
                  <strong>DateOfBirth</strong>
                </label>
                <input
                  type="date"
                  name="DateOfBirth"
                  onChange={handleFieldChange}
                  className="form-control rounded-0"
                />
                {errors.DateOfBirth && (
                  <span className="text-danger">{errors.DateOfBirth}</span>
                )}
              </div>
            </div>
            <div className="row">
              <div className="col-md-6 mb-3">
                <label htmlFor="Address">
                  <strong>Address</strong>
                </label>
                <input
                  type="text"
                  placeholder="Enter Address"
                  name="Address"
                  onChange={handleFieldChange}
                  className="form-control rounded-0"
                ></input>
                {errors.Address && (
                  <span className="text-danger">{errors.Address}</span>
                )}
              </div>
              <div className="col-md-6 mb-3">
                <label htmlFor="Phone">
                  <strong>Phone Number</strong>
                </label>
                <input
                  type="text"
                  placeholder="Enter Phone Number"
                  name="Phone"
                  onChange={handleFieldChange}
                  className="form-control rounded-0"
                ></input>
                {errors.Phone && (
                  <span className="text-danger">{errors.Phone}</span>
                )}
              </div>
            </div>

            <button type="submit" className="btn btn-success w-100 rounded-0">
              Sign up
            </button>
            <p className="text-center mt-3">
              By clicking on sign in you are accepting our terms and conditions.
            </p>

            <Link
              to={PATIENT_LOGIN_ROUTE}
              className="btn btn-default border w-100 bg-light rounded-0 text-decoration-none"
            >
              Log in
            </Link>
          </form>
        </div>
      </div>
      <ToastNotification
        background="success"
        show={showToast}
        message={`${respnseStatus} Please Note Your User ID`}
        onClose={handleCloseToast}
      />
    </div>
  );
};

export default PatientRegistrationForm;

//<div>
//     <NavigatonBar/>
//   <div classFullName="container-fluid reg-main-container">
//     <h1>Patient Registeration form</h1>
//   </div>
//   <div classFullName="container-fluid doc-register-form-container">
//     <Form onSubmit={handleSubmit}>
//       <div classFullName="row">
//         <div classFullName="col-lg-4">
//           <Form.Group classFullName="mb-3" controlId="formBasicPassword">
//             <Form.Label>User Id</Form.Label>
//             <Form.Control
//               type="text"
//               placeholder="Enter User Id with Number Only"
//               FullName="UserID"
//               onChange={handleFieldChange}
//             />
//           </Form.Group>
//         </div>
//         <div classFullName="col-lg-4">
//           <Form.Group classFullName="mb-3" controlId="formBasicPassword">
//             <Form.Label>Full FullName</Form.Label>
//             <Form.Control
//               type="text"
//               placeholder="Enter Your Full FullName"
//               FullName="FullFullName"
//               onChange={handleFieldChange}
//             />
//           </Form.Group>
//         </div>
//       </div>

//       <div classFullName="row">
//         <div classFullName="col-lg-4">
//           <Form.Group classFullName="mb-3" controlId="formBasicPassword">
//             <Form.Label>DateOfBirthOfBirth Of Birth</Form.Label>
//             <Form.Control
//               type="DateOfBirthOfBirth"
//               placeholder="Enter Your DateOfBirthOfBirth Of Birth"
//               FullName="DateOfBirthOfBirthOfBirth"
//               onChange={handleFieldChange}
//             />
//           </Form.Group>
//         </div>
//         <div classFullName="col-lg-4">
//           <Form.Group classFullName="mb-3" controlId="formBasicPassword">
//             <Form.Label>Gender</Form.Label>
//             <Form.Control
//               type="text"
//               placeholder="Enter Your Gender"
//               FullName="Gender"
//               onChange={handleFieldChange}
//             />
//           </Form.Group>
//         </div>
//       </div>

//       <div classFullName="row">
//         <div classFullName="col-lg-4">
//           <Form.Group classFullName="mb-3" controlId="formBasicPassword">
//             <Form.Label>Password</Form.Label>
//             <Form.Control
//               type="Password"
//               placeholder="Enter Your New Password"
//               FullName="Password"
//               onChange={handleFieldChange}
//             />
//           </Form.Group>
//         </div>
//         <div classFullName="col-lg-4">
//           <Form.Group classFullName="mb-3" controlId="formBasicPassword">
//             <Form.Label>Phone Number</Form.Label>
//             <Form.Control
//               type="text"
//               placeholder="Enter Your Phone Number"
//               FullName="Phone"
//               onChange={handleFieldChange}
//             />
//           </Form.Group>
//         </div>
//       </div>

//       <div classFullName="row">
//         <div classFullName="col-lg-4">
//           <Form.Group classFullName="mb-3" controlId="formBasicPassword">
//             <Form.Label>Address</Form.Label>
//             <Form.Control
//               type="text"
//               placeholder="Enter Your Address"
//               FullName="Address"
//               onChange={handleFieldChange}
//             />
//           </Form.Group>
//         </div>
//       </div>

//       <div classFullName="row">
//         <div classFullName="col-lg-4">
//           <Button type="submit" variant="primary">
//             Register Patient
//           </Button>
//           <LinkContainer to={BASE_ROUTE} classFullName="reg-buttons-to-home">
//             <Button>Home</Button>
//           </LinkContainer>
//         </div>
//       </div>
//     </Form>
//   </div>
//   <ToastNotification
//     background="success"
//     show={showToast}
//     message={`${respnseStatus} Please Note Your User ID`}
//     onClose={handleCloseToast}
//   />
//   {/* <ToastContainer position="top-end">
//     <Toast
//       onClose={handleCloseToast}
//       bg="success"
//       show={showToast}
//       delay={10000}
//       autohide
//     >
//       <Toast.Header>
//         <strong classFullName="me-auto">Bootstrap</strong>
//       </Toast.Header>
//       <Toast.Body classFullName="text-white">{`${respnseStatus} Please Note Your User ID`}</Toast.Body>
//     </Toast>
//   </ToastContainer> */}
// </div>
