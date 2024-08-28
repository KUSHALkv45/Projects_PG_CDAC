import { Alert } from "react-bootstrap";

const Header =(props) =>{
    return(
        <Alert variant={props.variant}>{props.message}</Alert>
    );
}

export default Header
