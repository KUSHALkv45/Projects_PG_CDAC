import './App.css';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Home from './pages/Home';
import ListTreatmentRecords from './components/ui/ListTreatmentRecords';
import ContactUs from './pages/ContactUs';
import About from './pages/About';
import DoctorLogin from './components/ui/DoctorsLogin';
import PatientLogin from './components/ui/PatientLogin';
import { ABOUT_ROUTE, ADD_TREATMENT_TABLE_ROUTE, BASE_ROUTE, CONTACTUS_ROUTE, DOCTORS_LOGIN_ROUTE, DOCTOR_PATIENT_TREATMENT_TABLE_ROUTE, DOCTOR_REGISTER_ROUTE, EDIT_TREATMENT_TABLE_ROUTE, LISTMEDICAL_RECORDS_ROUTE, PATIENT_LOGIN_ROUTE, PATIENT_REGISTER_ROUTE, PATIENT_TREATMENT_TABLE_ROUTE } from './constants/AppRouts';
import DoctorRegistrationForm from './components/ui/DoctorRegisterationForm';
import PatientRegistrationForm from './components/ui/PatientRegisterationForm';
import DoctorsPatientTreatmentsTable from './components/ui/DoctorsPatientTreatmentsTable';
import TreatmentEditForm from './components/ui/TreatmentEditForm';
import AddNewTreatment from './components/ui/AddNewTreatment';
import NavigatonBar from './components/ui/NavigationBar';
import PatientTreatmentTable from './components/ui/PatientTreatmentsTable';
//import { About } from './components/About';
//import { LoginForm } from './components/LoginForm';

function App() {
  return (
    <BrowserRouter>
      <NavigatonBar/>
      <Routes>
        <Route path={BASE_ROUTE} element={<Home/>}></Route>
        <Route path={LISTMEDICAL_RECORDS_ROUTE} element={<ListTreatmentRecords/>}></Route>
        <Route path={CONTACTUS_ROUTE} element={<ContactUs/>}></Route>
        <Route path={ABOUT_ROUTE} element={<About/>}></Route>
        <Route path={DOCTORS_LOGIN_ROUTE} element={<DoctorLogin/>}></Route>
        <Route path={PATIENT_LOGIN_ROUTE} element={<PatientLogin/>}></Route>
        <Route path={DOCTOR_REGISTER_ROUTE} element={<DoctorRegistrationForm/>}></Route>
        <Route path={PATIENT_REGISTER_ROUTE} element={<PatientRegistrationForm/>}></Route>
        <Route path={DOCTOR_PATIENT_TREATMENT_TABLE_ROUTE} element={<DoctorsPatientTreatmentsTable/>}></Route>
        <Route path={EDIT_TREATMENT_TABLE_ROUTE} element={<TreatmentEditForm/>}></Route>
        <Route path={ADD_TREATMENT_TABLE_ROUTE} element={<AddNewTreatment/>}></Route>
        <Route path={PATIENT_TREATMENT_TABLE_ROUTE} element={<PatientTreatmentTable/>}></Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;