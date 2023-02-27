import React from "react";
import FacebookIcon from "@mui/icons-material/Facebook";
import LinkedInIcon from "@mui/icons-material/LinkedIn";
import Grid from "@mui/material/Grid";

// style={{ backgroundColor: "#ef4815", paddingTop: "7px", paddingLeft: "40px", marginTop: "30px"}}
const Footer = () => {
  return (
    <Grid
      container
      spacing={{ xs: 2, md: 3 }}
      columns={{ xs: 4, sm: 8, md: 12 }}
      style={{
        marginTop: "50px",
        backgroundColor: "#ef4815",
        paddingLeft: "40px",
        paddingBottom: "10px",
      }}
    >
      <Grid item xs={10}>
        <FacebookIcon style={{ color: "#043465", fontSize: "35px" }} />
        <LinkedInIcon style={{ color: "#043465", fontSize: "35px" }} />
      </Grid>
      <Grid item xs={2}>
        <p style={{ color: "#043465", fontWeight: "bolder" }}>
          FAQ | CONTACT US
        </p>
      </Grid>
    </Grid>
  );
};

export default Footer;
