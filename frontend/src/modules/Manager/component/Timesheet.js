import React, { useEffect, useState } from "react";
import Grid from "@mui/material/Grid";
import Box from "@mui/material/Box";
import Paper from "@mui/material/Paper";
import { experimentalStyled as styled } from "@mui/material/styles";
import { TextField } from "@mui/material";
import "./Timesheet.css";
import SearchIcon from "@mui/icons-material/Search";
import InputAdornment from "@mui/material/InputAdornment";
import logo from "../../../assets/Capture.png";
import axios from 'axios';

const Item = styled(Paper)(({ theme }) => ({
  backgroundColor: "#043465",
  ...theme.typography.body2,
  padding: theme.spacing(2),
  color: "white",
  height: "240px",
}));

const Timesheet = ({ data, display }) => {
 
 const handleClick = (e) => {
    const f=e.target.id;
     
      const url=`http://localhost:8080/java/Manager/Timesheet/Approve/${f}`;
    axios.patch(url).then((result)=>{
      window.location.reload(false);
    console.log(result)
   
   }).catch((error)=>{
        console.log(error)
   });

   
  };




  return (
    <div
      style={{
        backgroundImage: `url(${logo})`,
        backgroundRepeat: "no-repeat",
        backgroundPosition: "top center",
        backgroundSize: "400px",
        backgroundPositionY: "100px",
      }}
    >
      <Box sx={{ display: "flex", alignItems: "flex-end", marginTop: "20px" }}>
        <span className="timesheet">{display}</span>{" "}
        <TextField
          id="input-with-icon-textfield"
          label="Search Timesheet"
          InputProps={{
            startAdornment: (
              <InputAdornment position="start">
                <SearchIcon
                  sx={{ color: "#ef4815", mr: 0, my: 1, fontSize: "30px" }}
                />
              </InputAdornment>
            ),
          }}
          variant="standard"
          style={{ marginRight: "20px" }}
        />
      </Box>

      <Box sx={{ flexGrow: 1 }} style={{ margin: "180px 20px 0px 20px" }}>
        <Grid
          container
          spacing={{ xs: 3, md: 3 }}
          columns={{ xs: 4, sm: 8, md: 12 }}
        >
          {data.map((item) => (
            <Grid item xs={2} sm={2} md={3}>
              <Item>
                <h2>{item.timesheetId}</h2>
                <p>Employee Name:{item.employee.employee_name}</p>
                <p>Start date: {item.startDate}</p>
                <p>End Date:{item.endDate}</p>
                <p>Allocation:{item.hours}</p>
                <p>Status:{item.approval}</p>
                <button onClick={handleClick}  id={item.timesheetId} >Approve</button>
              </Item>
            </Grid>
          ))}
        </Grid>
      </Box>
    </div>
  );
};

export default Timesheet;
