function PatientRegistrationValidation(values){
    
    let errors ={}
   
   //user Id validation
    if(values.UserID === ""){
        errors.UserID = "Please Enter User ID"
    }
    else{
        errors.UserID=""
    }

     //user Id validation
     if(values.FullName === ""){
        errors.FullName = "Please Enter Full FullName"
    }
    else{
        errors.FullName=""
    }


    //Password validation
    if(values.Password ===""){
        errors.Password="Password should not be empty"
    }
    else{
        errors.Password =""
    }


    // Confirm Password
        if (values.confirmPassword === "") {
             errors.confirmPassword = "Please re-enter Password";
        } else if (values.Password !== values.confirmPassword) {
             errors.confirmPassword = "Passwords do not match";
        } else {
            errors.confirmPassword = "";
        }

   

    //Enter Gender
    if(values.Gender === ""){
        errors.Gender = "Please select Gender"
    }
    else{
        errors.Gender=""
    }


    // birth DateOfBirth 
    if(values.DateOfBirth === ""){
        errors.DateOfBirth = "Please enter a DateOfBirth"
    }
    else{
        errors.DateOfBirth=""
    }


    // Adderss
    if(values.Address === ""){
        errors.Address = "Enter Address "
    }
    else{
        errors.Address=""
    }

    // Adderss
    if(values.Phone === ""){
        errors.Phone = "Enter Phone "
    }
    else{
        errors.Phone=""
    }
   

    
    return errors;
}
export default PatientRegistrationValidation;