import { useState } from "react";
import { Button, Form, Toast, ToastContainer } from "react-bootstrap";
import { registerDoctor } from "../../services/DoctorService";
import { BASE_ROUTE, DOCTORS_LOGIN_ROUTE } from "../../constants/AppRouts";
import { LinkContainer } from "react-router-bootstrap";
import "../../css/RegistrationForm.css";
import { ToastNotification } from "../library/ToastNotification";
import { Link } from "react-router-dom";
import DoctorRegistrationValidation from "../../services/DoctorRegistrationValidation";

const DoctorRegistrationForm = () => {
  const [errors, setErrors] = useState({});
  const [doctorFormData, setDoctorFormData] = useState({
    UserID: "",
    Password: "",
    FullName: "",
    Specialization: "",
    LicenseNumber: "",
    Address: "",
    Phone: "",
    confirmPassword: "",
  });
  const [showToast, setShowToast] = useState(false);
  const [respnseStatus, setResponseStatus] = useState("");

  const handleFieldChange = (event) => {
    setDoctorFormData({
      ...doctorFormData,
      [event.target.name]: event.target.value,
    });
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    console.log(doctorFormData);
    const validationErrors = DoctorRegistrationValidation(doctorFormData);
    setErrors(validationErrors);
    //if (Object.keys(validationErrors).length === 0) {
      if(errors.UserID ===""  && errors.FullName === "" && errors.Password === "" && errors.Specialization === "" &&
        errors.LicenseNumber === "" && errors.Address === "" && errors.Phone === "")
        {
        registerDoctor(doctorFormData)
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
          <h2 className="text-center text">Doctor's Registration Form</h2>
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
                <label htmlFor="Specialization">
                  <strong>Specialization</strong>
                </label>
                <input
                  type="text"
                  placeholder="Enter Specialization"
                  name="Specialization"
                  onChange={handleFieldChange}
                  className="form-control rounded-0"
                ></input>
                {errors.Specialization && (
                  <span className="text-danger">{errors.Specialization}</span>
                )}
              </div>
              <div className="col-md-6 mb-3">
                <label htmlFor="LicenseNumber">
                  <strong>License Number</strong>
                </label>
                <input
                  type="text"
                  placeholder="Enter Valid License Number"
                  name="LicenseNumber"
                  onChange={handleFieldChange}
                  className="form-control rounded-0"
                ></input>
                {errors.LicenseNumber && (
                  <span className="text-danger">{errors.LicenseNumber}</span>
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
              to={DOCTORS_LOGIN_ROUTE}
              className="btn btn-default border w-100 bg-light rounded-0 text-decoration-none"
            >
              Log in
            </Link>
          </form>
        </div>
        <ToastNotification
          background="success"
          show={showToast}
          message={`${respnseStatus} Please Note Your User ID`}
          onClose={handleCloseToast}
        />
      </div>
    </div>
  );
};

export default DoctorRegistrationForm;

// <div>
//     <NavigatonBar/>
//   <div className="container-fluid reg-main-container">
//     <h1>Doctor Registeration form</h1>
//   </div>
//   <div className="container-fluid doc-register-form-container">
//     <Form onSubmit={handleSubmit}>
//       <div className="row">
//         <div className="col-lg-4">
//           <Form.Group className="mb-3" controlId="formBasicPassword">
//             <Form.Label>User Id</Form.Label>
//             <Form.Control
//               type="text"
//               placeholder="Enter User Id with Number Only"
//               name="UserID"
//               onChange={handleFieldChange}
//             />
//           </Form.Group>
//         </div>
//         <div className="col-lg-4">
//           <Form.Group className="mb-3" controlId="formBasicPassword">
//             <Form.Label>Full Name</Form.Label>
//             <Form.Control
//               type="text"
//               placeholder="Enter Your Full Name"
//               name="FullName"
//               onChange={handleFieldChange}
//             />
//           </Form.Group>
//         </div>
//       </div>

//       <div className="row">
//         <div className="col-lg-4">
//           <Form.Group className="mb-3" controlId="formBasicPassword">
//             <Form.Label>Specialization</Form.Label>
//             <Form.Control
//               type="text"
//               placeholder="Enter Your Specialization"
//               name="Specialization"
//               onChange={handleFieldChange}
//             />
//           </Form.Group>
//         </div>
//         <div className="col-lg-4">
//           <Form.Group className="mb-3" controlId="formBasicPassword">
//             <Form.Label>LicenseNumber</Form.Label>
//             <Form.Control
//               type="text"
//               placeholder="Enter Your LicenseNumber"
//               name="LicenseNumber"
//               onChange={handleFieldChange}
//             />
//           </Form.Group>
//         </div>
//       </div>

//       <div className="row">
//         <div className="col-lg-4">
//           <Form.Group className="mb-3" controlId="formBasicPassword">
//             <Form.Label>Password</Form.Label>
//             <Form.Control
//               type="password"
//               placeholder="Enter Your New Password"
//               name="Password"
//               onChange={handleFieldChange}
//             />
//           </Form.Group>
//         </div>
//         <div className="col-lg-4">
//           <Form.Group className="mb-3" controlId="formBasicPassword">
//             <Form.Label>Phone Number</Form.Label>
//             <Form.Control
//               type="text"
//               placeholder="Enter Your Phone Number"
//               name="Phone"
//               onChange={handleFieldChange}
//             />
//           </Form.Group>
//         </div>
//       </div>

//       <div className="row">
//         <div className="col-lg-4">
//           <Form.Group className="mb-3" controlId="formBasicPassword">
//             <Form.Label>Address</Form.Label>
//             <Form.Control
//               type="text"
//               placeholder="Enter Your Address"
//               name="Address"
//               onChange={handleFieldChange}
//             />
//           </Form.Group>
//         </div>
//       </div>

//       <div className="row">
//         <div className="col-lg-4">
//           <Button type="submit" variant="primary">
//             Register Doctor
//           </Button>
//           <LinkContainer to={BASE_ROUTE} className="reg-buttons-to-home">
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
//         <strong className="me-auto">Bootstrap</strong>
//       </Toast.Header>
//       <Toast.Body className="text-white">{`${respnseStatus} Please Note Your User ID`}</Toast.Body>
//     </Toast>
//   </ToastContainer> */}
// </div>
