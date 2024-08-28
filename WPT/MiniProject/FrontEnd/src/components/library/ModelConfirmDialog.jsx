import { Button, Modal } from "react-bootstrap";

export function ModelConfirmationDialog(props){
    return(
        <Modal show={props.show} onHide={props.onClose}>
        <Modal.Header closeButton>
          <Modal.Title>Confiramtion</Modal.Title>
        </Modal.Header>
        <Modal.Body>{props.message}</Modal.Body>
        <Modal.Footer>
          <Button variant="success" onClick={props.onYes}>
            Yes
          </Button>
          <Button variant="danger" onClick={props.closeModel}>
            No
          </Button>
        </Modal.Footer>
      </Modal>
    );
}