import React from "react";
import data from "../../../assets/data/showprojecttomanager.json";
import Grid from "@mui/material/Grid";
import Box from "@mui/material/Box";
import Paper from "@mui/material/Paper";
import { experimentalStyled as styled } from "@mui/material/styles";
import HistoryTable from "./HistoryTable";

const Item = styled(Paper)(({ theme }) => ({
  backgroundColor: "#043465",
  ...theme.typography.body2,
  padding: theme.spacing(2),
  color: "white",
  height: "180px",
}));

const ReporteeList = () => {
  return (
    <div>
      <Box sx={{ flexGrow: 1 }} style={{ margin: "60px 20px 0px 20px" }}>
        <Grid
          container
          spacing={{ xs: 3, md: 3 }}
          columns={{ xs: 4, sm: 8, md: 12 }}
        >
          {data.map((item) => (
            <Grid item xs={2} sm={2} md={3}>
              <Item>
                <h2>{item.employee_id}</h2>
                <p>Employee Name: {item.employee.employee_name}</p>
                <p>Project Name: {item.projectName}</p>
                <p>Project Id:{item.project_id}</p>
                <p>Click here for history</p>
              </Item>
            </Grid>
          ))}
        </Grid>
      </Box>
      <Box sx={{ flexGrow: 1 }} style={{ margin: "60px auto 0px auto" }}>
        <HistoryTable />
      </Box>
    </div>
  );
};

export default ReporteeList;
