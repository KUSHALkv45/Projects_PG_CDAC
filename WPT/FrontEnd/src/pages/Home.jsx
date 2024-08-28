import React from "react";
import "../css/Home.css";
import NavigatonBar from "../components/ui/NavigationBar";
import { Carousel } from "react-bootstrap";
import InformationCard from "../components/library/InformationCard";
import Footer from "../components/library/Footer";

//import { Alert, Container } from 'react-bootstrap';
const Home = () => {
  return (
    <>
      <NavigatonBar />
      <div className="Home-bg-container d-flex justify-content-center align-items-center">
        <div className="text-center">
          <h1 className="Homepage-main-title">Welcome to FirstCare</h1>
          <p className="Homepage-main-subline">
            "Streamline Your Health: Your Comprehensive Medical Record
            Management Platform"
            <br></br>
            "Unlock Your Health Journey: Seamlessly Manage Your Medical Records
            Online"
          </p>
        </div>
      </div>
      <div className="container-fluid">
      <div className="section-container">
        <div className="hero-section">
          <div className="text-section">
            <p className="text-headline" style={{ marginBottom: "20px" }}>
              ❤️ Your Health, Our Priority.
            </p>
            <h2 className="text-title" style={{ marginTop: "20px" }}>
              Check and Update your Medical Record from any doctor at any
              time...
            </h2>

            <br></br>
            <p className="text-descritpion">
              "Efficient patient history record management is the heartbeat of
              healthcare, ensuring that every patient's story is heard and every
              treatment is tailored."
            </p>
            <div className="text-stats">
              <div className="text-stats-container">
                <p>50k+</p>
                <p>Patient Record</p>
              </div>

              <div className="text-stats-container">
                <p>1000+</p>
                <p>Expert Doctors</p>
              </div>

              <div className="text-stats-container">
                <p>5</p>
                <p>Years of Experience❤</p>
              </div>
            </div>
          </div>

          <div className="hero-image-section">
            <img src='https://i.pinimg.com/originals/61/b8/f6/61b8f6e014116aca1db6f85be6485203.png' 
                  alt="Doctor" 
                  style={{width:"600px", height:"auto"}}/>
          </div>
        </div>
      </div>

      <div>
        <div className="info-section" id="services">
          <div className="info-title-content">
            <h3 className="info-title">
              <span>What We Do</span>
            </h3>
            <p className="info-description">
              At our platform, we prioritize your health by offering a robust
              and user-friendly treatment history record management system. Our
              services are designed to provide seamless access to your medical
              history, ensuring you receive the best possible care.Your medical
              data is stored securely, ensuring your privacy is always
              protected.
            </p>
          </div>

          <div className="info-cards-content">
            <InformationCard
              title="Emergency Care"
              description="We understand the importance of accurate and up-to-date treatment history, especially in emergencies. Our system ensures that all treatments and interventions are meticulously recorded, 
          allowing healthcare providers to access vital patient information quickly and make informed decisions. This comprehensive record-keeping facilitates continuity of care, 
          reduces the risk of errors, and ensures 
          that every patient receives personalized and effective treatment based on their medical history."
            />

            <InformationCard
              title="Track Medical Record"
              description=" Easily share your medical history with any healthcare provider,
           ensuring they have all the information needed to provide the best care.Have instant access to your medical records whenever you need them, 
           whether during an emergency, a routine check-up, or while traveling.Keep a comprehensive log of your health journey, from past illnesses to ongoing treatments, enabling you and your doctors to monitor progress over time. "
            />

            <InformationCard
              title="Our Support"
              description="Our platform is designed to ensure that your experience is as seamless as possible. 
          From guiding you through the process of uploading new records to helping you retrieve past medical documents, our support team is committed to making sure you have all the information you need at your fingertips. 
          With our expert support, you can rest assured that your treatment history is accurately maintained and easily accessible, empowering you to focus on your health and well-being without the hassle of managing complex medical records on your own. "
            />
          </div>
        </div>

        <div className="ba-section">
          <div className="ba-image-content">
            <img src="https://alkaison.github.io/Health-Plus/static/media/doctor-book-appointment.edb3f4ac282ff3fefaec.png" alt="Doctor Group" className="ba-image1" />
          </div>

          <div className="ba-text-content">
            <h3 className="ba-title">
              <span>Why to Record Treatment History</span>
            </h3>
            <p className="ba-description">
              Your health is unique, and so are your healthcare needs. At First
              Care, we believe in personalized solutions tailored to your
              specific requirements. Whether it's managing chronic conditions,
              monitoring health progress, or coordinating with multiple
              healthcare providers, our platform empowers you to take control of
              your health journey.
            </p>

            <p className="ba-checks ">
              🔷 Safety and confidentiality of your treatment records
            </p>
            <p className="ba-checks">🔷 Emergency Care</p>
            <p className="ba-checks"> 🔷 Contact us 24/7</p>
            <p className="ba-checks ba-check-last">
              🔷 Quick and easy registration process
            </p>
          </div>
        </div>
      </div>
      </div>
      <Footer/>
    </>
  );
};

export default Home;
