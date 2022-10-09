import { renderEditCarOwnerForm } from "../../components/forms/car-owner-form.js";
(async () => {
  const urlParams = new URLSearchParams(window.location.search);
  const ownerId = urlParams.get("id");

  await renderEditCarOwnerForm("carOwnerFormContainer", ownerId);
})();
