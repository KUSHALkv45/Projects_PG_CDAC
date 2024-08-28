import React from "react";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import {
  faEnvelope,
  faPhone,
  faMapMarkerAlt,
} from "@fortawesome/free-solid-svg-icons";
import "./../css/Contact.css";
import Footer from "../components/library/Footer";

const ContactUs = () => {
  return (
    <>
    <div className="contact-page mt-5 p-3">
      <div className="contact-container">
        <h1 className="contact-heading">Contact Us</h1>
        <p className="text-center">
          If you have any questions, concerns, or would like to update your
          health history record, please don't hesitate to reach out to us. 
          <br></br>
          We're here to support you every step of the way.
        </p>
        <div className="contact-details">
          <div className="card">
            <div className="card-body">
              <FontAwesomeIcon icon={faPhone} size="2x" />
              <h5 className="card-title">Phone</h5>
              <p className="card-text">+22 222-4466</p>
              <a href="tel:+15555555555" className="btn btn-primary">
                Call us
              </a>
            </div>
          </div>
          <div className="card">
            <div className="card-body">
              <FontAwesomeIcon icon={faEnvelope} size="2x" />
              <h5 className="card-title">Email</h5>
              <p className="card-text">FirstCare@Cdac.in</p>
              <a href="mailto:contact@example.com" className="btn btn-primary">
                Email us
              </a>
            </div>
          </div>
          <div className="card">
            <div className="card-body">
              <FontAwesomeIcon icon={faMapMarkerAlt} size="2x" />
              <h5 className="card-title">Address</h5>
              <p className="card-text">Cdac Mumbai</p>
              <a
                href="https://maps.google.com/?q=1234+Example+St, City, Country"
                className="btn btn-primary"
              >
                Find us
              </a>
            </div>
          </div>
        </div>
      </div>
      <div className="accordion p-2" id="accordionExample">
        <h2 id="aeh">FAQs</h2>
        <div className="accordion-item">
          <h2 className="accordion-header" id="headingOne">
            <button
              className="accordion-button collapsed"
              type="button"
              data-bs-toggle="collapse"
              data-bs-target="#collapseOne"
              aria-expanded="false"
              aria-controls="collapseOne"
            >
              What are the services we provide?
            </button>
          </h2>
          <div
            id="collapseOne"
            className="accordion-collapse collapse"
            aria-labelledby="headingOne"
            data-bs-parent="#accordionExample"
          >
            <div className="accordion-body">
              <strong>We maintain records on patient-doctor treatments exclusively.</strong> 
            </div>
          </div>
        </div>
        <div className="accordion-item">
          <h2 className="accordion-header" id="headingTwo">
            <button
              className="accordion-button collapsed"
              type="button"
              data-bs-toggle="collapse"
              data-bs-target="#collapseTwo"
              aria-expanded="false"
              aria-controls="collapseTwo"
            >
              Can patient edit the treatement details ?
            </button>
          </h2>
          <div
            id="collapseTwo"
            className="accordion-collapse collapse"
            aria-labelledby="headingTwo"
            data-bs-parent="#accordionExample"
          >
            <div className="accordion-body">
              <strong>No only doctor has permission to edit and patient can only view.</strong>
            </div>
          </div>
        </div>
        <div className="accordion-item">
          <h2 className="accordion-header" id="headingThree">
            <button
              className="accordion-button collapsed"
              type="button"
              data-bs-toggle="collapse"
              data-bs-target="#collapseThree"
              aria-expanded="false"
              aria-controls="collapseThree"
            >
              Is this website trustable?
            </button>
          </h2>
          <div
            id="collapseThree"
            className="accordion-collapse collapse"
            aria-labelledby="headingThree"
            data-bs-parent="#accordionExample"
          >
            <div className="accordion-body">
              <strong>Yes, we provide access only to trusted and certified doctors.</strong>
            </div>
          </div>
        </div>
      </div>
    </div>
    <Footer/>
    </>
  );
};

export default ContactUs;
