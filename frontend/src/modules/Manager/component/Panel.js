import React, { useEffect, useState } from "react";
import "./Panel.css";
import MenuItem from "@mui/material/MenuItem";
import { Select, InputLabel } from "@mui/material";
import axios from "axios";
const Panel = ({ changeDisplay,data}) => {
  const [selected, setSelected] = useState("Reportees Timesheet");
  const [projectData,setProjectData]=useState([])
 



  const selectionChangeHandler = (event) => {
    console.log(selected);
    setSelected(event.target.value);
  };

  const handleClick = (e) => {
    changeDisplay(e.target.id);
  };
  const dataOfManager={employeeId:data };
  
  useEffect(() => {
    const url='http://localhost:8080/java/Manager/Project';
    axios.post(url,dataOfManager).then((result)=>{
         setProjectData(result.data)
          console.log(result.data);
   }).catch((error)=>{
        console.log(error)
   });
  },[]);
     
  return (
    <div className="panel-container">
      <p className="left-panel" onClick={handleClick} id="timesheet">
        Timesheet
      </p>

      <p>
  
    <Select
          style={{ marginTop: 60 }}
          className="panel"
          value={selected}
          onChange={selectionChangeHandler}
          label="Reportees Timesheet"
        >
          <InputLabel>Reportees Timesheet</InputLabel>

       
          {projectData.map((item) => (
           <MenuItem
           id={item.project_id}
           value={item.project_id}
           key={item.project_id}
           onClick={handleClick}
           style={{   color: "white", backgroundColor: "#ef4815" }}
         >
      {item.projectName}
         </MenuItem>
          ))}
          {/* <MenuItem
            value="project1"
            style={{ color: "#043465", backgroundColor: "#ef4815" }}
            onClick={handleClick}
            id="project1"
          >
            Project 1
          </MenuItem>

          <MenuItem
            onClick={handleClick}
            id="project2"
            value="project2"
            style={{ color: "#043465", backgroundColor: "#ef4815" }}
          >
            Project 2
          </MenuItem> */}
        </Select>
      </p>

      <p className="left-panel" id="reportee-list" onClick={handleClick}>
        Reportee List
      </p>
    </div>
  );
};

export default Panel;
