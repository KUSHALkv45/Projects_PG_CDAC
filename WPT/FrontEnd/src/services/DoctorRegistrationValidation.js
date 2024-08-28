function DoctorRegistrationValidation(values){
   
    let errors ={}
    console.log(values);
  
   //user Id validation
    if(values.UserID === ""){
        errors.UserID = "Please Enter User ID"
    }
    else{
        errors.UserID=""
    }

     //user Id validation
     if(values.FullName === ""){
        errors.FullName = "Please Enter Full Name"
    }
    else{
        errors.FullName=""
    }


    //password validation
    if(values.Password ===""){
        errors.Password="Password should not be empty"
    }
    else{
        errors.Password =""
    }


    // Confirm password
        if (values.confirmPassword === "") {
             errors.confirmPassword = "Please re-enter password";
        } else if (values.Password !== values.confirmPassword) {
             errors.confirmPassword = "Password must be same";
        } else {
            errors.confirmPassword = "";
        }

    //Enter specialization
    if(values.Specialization === ""){
        errors.Specialization = "You are specialist in"
    }
    else{
        errors.Specialization=""
    }


    // Liscense number
    if(values.LicenseNumber === ""){
        errors.LicenseNumber = "Enter License Number "
    }
    else{
        errors.LicenseNumber=""
    }


    // Adderss
    if(values.Address === ""){
        errors.Address = "Enter detailed Address "
    }
    else{
        errors.Address=""
    }

    // Adderss
    if(values.Phone === ""){
        errors.Phone = "Enter valid phone number "
    }
    else{
        errors.Phone=""
    }
  
    return errors;
}
export default DoctorRegistrationValidation;