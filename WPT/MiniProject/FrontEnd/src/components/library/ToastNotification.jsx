import { Toast, ToastContainer } from "react-bootstrap";

export function ToastNotification(props){
    return(
        <ToastContainer position="top-end">
        <Toast
          onClose={props.onClose}
          bg={props.background}
          show={props.show}
          delay={5000}
          autohide
        >
          <Toast.Header>
            <strong className="me-auto">Confirmation</strong>
          </Toast.Header>
          <Toast.Body>{props.message}</Toast.Body>
        </Toast>
      </ToastContainer>
    );
}