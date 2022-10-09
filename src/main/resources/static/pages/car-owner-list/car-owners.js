import { renderCarOwnerTable } from "../../components/tables/car-owner-table.js";

const handleAddNewOwner = () => {
  document.getElementById("addNewOwner").addEventListener("click", () => {
    window.location.replace("../../pages/car-owner-add/car-owner-add.html");
  });
};

(async () => {
  handleAddNewOwner();
  await renderCarOwnerTable("carOwnerContainer");
})();
