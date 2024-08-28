import { Carousel } from "react-bootstrap";
import SolutionStep from "../components/library/SolutionStep";
import NavigatonBar from "../components/ui/NavigationBar";
import "../css/About.css";
import Footer from "../components/library/Footer";
const About = () => {
  return (
    <>
      {/* <Carousel data-bs-theme="dark">
        <Carousel.Item>
          <img
            className="d-block w-100"
            src="holder.js/800x400?text=First slide&bg=f5f5f5"
            alt="First slide"
          />
          <Carousel.Caption>
            <h5>First slide label</h5>
            <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
          </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item>
          <img
            className="d-block w-100"
            src="holder.js/800x400?text=Second slide&bg=eee"
            alt="Second slide"
          />
          <Carousel.Caption>
            <h5>Second slide label</h5>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
          </Carousel.Caption>
        </Carousel.Item>
        <Carousel.Item>
          <img
            className="d-block w-100"
            src="holder.js/800x400?text=Third slide&bg=e5e5e5"
            alt="Third slide"
          />
          <Carousel.Caption>
            <h5>Third slide label</h5>
            <p>
              Praesent commodo cursus magna, vel scelerisque nisl consectetur.
            </p>
          </Carousel.Caption>
        </Carousel.Item>
      </Carousel> */}
      <div className="main-container">
        <div className="about-section" id="about">
          <div className="about-image-content">
            <img
              src="/images/doctorim.png"
              alt="Doctor Group"
              className="about-image1"
            />
          </div>

          <div className="about-text-content">
            <h3 className="about-title">
              <span>About Us</span>
            </h3>
            <p className="about-description">
              Welcome to <span style={{ fontWeight: 600 }}>First Care </span> ,
              your trusted partner for accessible and personalized website for
              Medical Records . Our website offer online record display and
              editing, prioritizing your need. It is a All in one Patient-doctor
              record management Website.
            </p>

            <h4 className="about-text-title">Your Solutions</h4>

            <SolutionStep
              title="Choose a Category(patient/Doctor)"
              description="Find your need and complete it on First Care. We priotitize ur records and their privacy."
            />

            <SolutionStep
              title="U can Contact us easily"
              description="Choose the date and time that suits you best, and let our dedicated team of medical professionals ensure your well-being with personalized care."
            />
          </div>
        </div>
      </div>
      <Footer />
    </>
  );
};

export default About;
