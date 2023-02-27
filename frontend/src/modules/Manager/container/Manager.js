import React, { useEffect, useState } from "react";
import Footer from "../../Footer/Footer";
import Navbar from "../../Navbar/Navbar";
import Panel from "../component/Panel";
import Grid from "@mui/material/Grid";
import Timesheet from "../component/Timesheet";

import projectOne from "../../../assets/data/showtimesheettomanagerprojectwise.json";
import ReporteeList from "../component/ReporteeList";
import {useNavigate} from "react-router-dom";
import {useLocation} from "react-router-dom";
import axios from 'axios';
const Manager = () => {
  const [display, setDisplay] = useState();
  const [timsheetDisplay, setTimesheetDisplay] = useState([]);
 
  const location=useLocation();
  const [dataManager, setdataManager] = useState(location);
  const changeDisplay = (props) => {
    
    setDisplay(props);
  };
const dataOfManager={employeeId:dataManager.state.EmployeeId };
const dataOfManagerProject={employeeId:dataManager.state.EmployeeId,projectId:display };
  useEffect(() => {
    if (display == "timesheet") {
      const url='http://localhost:8080/java/Manager/Timesheet';
        
    axios.post(url,dataOfManager).then((result)=>{
     
        console.log(result.data);
        setTimesheetDisplay(result.data);
     
            console.log(result.data);
     }).catch((error)=>{
          console.log(error)
     });
     
    } else {
      const url='http://localhost:8080/java/Manager/Timesheet/Project';
        
      axios.post(url,dataOfManagerProject).then((result)=>{
       
          console.log(result.data);
          setTimesheetDisplay(result.data);
       
              console.log(result.data);
       }).catch((error)=>{
            console.log(error)
       });
      
    } 
    // else if (display == "project2") {
    //   setTimesheetDisplay(projectOne);
    // }
  }, [display]);

  return (
    <div>
      <Navbar data={dataManager.state.EmployeeName} />

      <Grid
        container
        spacing={{ xs: 2, md: 3 }}
        columns={{ xs: 4, sm: 8, md: 12 }}
      >
        <Grid item xs={4} md={4} sm={12}>
          <Panel changeDisplay={changeDisplay} data={dataManager.state.EmployeeId}/>
        </Grid>

        <Grid item xs={8} md={8}>
          {display == "reportee-list" ? (
            <ReporteeList />
          ) : (
            <Timesheet data={timsheetDisplay} display={display}  />
          )}
        </Grid>
      </Grid>

      <Footer />
    </div>
  );
};

export default Manager;
