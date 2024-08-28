function PatientLoginValidation(values){
    //alert("")
    let error ={}
    

    if(values.userId === ""){
        error.userId = "Invalid User ID"
    }
    else{
        error.userId=""
    }

    //password validation
    if(values.password ===""){
        error.password="Password should not be empty"
    }
    else{
        error.password =""
    }

    return error;
}
export default PatientLoginValidation;