import { Container, Nav, Navbar } from "react-bootstrap";
import { LinkContainer } from "react-router-bootstrap";
import '../../css/Nav.css'
import { ABOUT_ROUTE, BASE_ROUTE, CONTACTUS_ROUTE, DOCTORS_LOGIN_ROUTE, PATIENT_LOGIN_ROUTE } from "../../constants/AppRouts";
const NavigatonBar = () =>{
    return(
      <Navbar expand="lg" className="bg-body-tertiary shadow-lg fixed-top " bg="dark" data-bs-theme="dark">
      <Container className="nav-container">
        <Navbar.Brand href="#home">
          <h1 className='nav-logo'>
          First<span className='nav-logo-style'>Care</span>
          </h1>
        </Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="ml-auto">
            <LinkContainer to={BASE_ROUTE}>
                <Nav.Link>Home</Nav.Link>
            </LinkContainer>
            <LinkContainer to={ABOUT_ROUTE}>
                <Nav.Link>About</Nav.Link>
            </LinkContainer>
            <LinkContainer to={CONTACTUS_ROUTE}>
                <Nav.Link>Contact Us</Nav.Link>
            </LinkContainer>
            <LinkContainer to={DOCTORS_LOGIN_ROUTE}>
                <Nav.Link >Login Doctor</Nav.Link>
            </LinkContainer>
            <LinkContainer to={PATIENT_LOGIN_ROUTE}>
                <Nav.Link >Login Patient</Nav.Link>
            </LinkContainer>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
    ); 
}

export default NavigatonBar;