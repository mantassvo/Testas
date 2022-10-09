import {
  getCarOwnerById,
  saveCarOwner,
  updateCarOwner,
} from "../../commons/requests.js";

let formParentDivId = undefined;

const handleCarOwnerFormSubmit = async (form) => {
  form.addEventListener("submit", async (e) => {
    e.preventDefault();
    await submitCarOwner(
      form.companyName.value,
      form.address.value,
      form.phoneNo.value
    );
    window.location.replace("../../pages/car-owner-list/car-owners.html");
  });
};

const handleEditOwnerFormSubmit = async (form, ownerId) => {
  form.addEventListener("submit", async (e) => {
    e.preventDefault();
    await editCarOwner(
      form.companyName.value,
      form.address.value,
      form.phoneNo.value,
      ownerId
    );
    window.location.replace("../../pages/car-owner-list/car-owners.html");
  });
};

const editCarOwner = async (companyName, address, phoneNo, ownerId) => {
  const owner = { companyName, address, phoneNo };
  await updateCarOwner(owner, ownerId);
};

const submitCarOwner = async (companyName, address, phoneNo) => {
  const owner = { companyName, address, phoneNo };
  await saveCarOwner(owner);
};

const renderInputField = (form, name, id, defaultValue) => {
  const div = document.createElement("div");
  div.className = "mb-3";

  const label = document.createElement("label");
  label.for = id;
  label.innerText = name;

  const input = document.createElement("input");
  input.type = "text";
  input.name = id;
  input.id = id;
  input.className = "form-control";

  if (defaultValue) {
    input.value = defaultValue;
  }

  div.append(label, input);
  form.appendChild(div);
};

const renderSaveButton = (form) => {
  const div = document.createElement("div");
  div.className = "actions";

  const button = document.createElement("button");
  button.type = "submit";
  button.className = "btn btn-primary";
  button.innerText = "Save";

  div.appendChild(button);
  form.appendChild(div);
};

const renderEditButtons = (form) => {
  const div = document.createElement("div");
  div.className = "actions";

  const saveButton = document.createElement("button");
  saveButton.type = "submit";
  saveButton.className = "btn btn-success";
  saveButton.innerText = "Save";

  const cancelButton = document.createElement("button");
  cancelButton.type = "submit";
  cancelButton.className = "btn btn-danger";
  cancelButton.innerText = "Cancel";
  cancelButton.addEventListener("click", () =>
    window.location.replace("../../pages/car-owner-list/car-owners.html")
  );

  div.append(saveButton, cancelButton);
  form.appendChild(div);
};

export const renderSaveCarOwnerForm = async (targetId) => {
  formParentDivId = targetId;
  const form = document.createElement("form");
  form.id = "carOwnerForm";

  renderInputField(form, "Company name", "companyName");
  renderInputField(form, "Address", "address");
  renderInputField(form, "Phone number", "phoneNo");
  renderSaveButton(form);

  await handleCarOwnerFormSubmit(form);
  document.getElementById(formParentDivId).appendChild(form);
};

export const renderEditCarOwnerForm = async (targetId, ownerId) => {
  formParentDivId = targetId;
  const form = document.createElement("form");
  form.id = "carOwnerForm";

  const owner = await getCarOwnerById(ownerId);

  renderInputField(form, "Company name", "companyName", owner.companyName);
  renderInputField(form, "Address", "address", owner.address);
  renderInputField(form, "Phone number", "phoneNo", owner.phoneNo);
  renderEditButtons(form);

  await handleEditOwnerFormSubmit(form, ownerId);
  document.getElementById(formParentDivId).appendChild(form);
};
