const API_BASE_URL = "http://localhost:8080";

export const getAllCarOwners = async () => {
  const response = await fetch(`${API_BASE_URL}/car-owner`);
  const carOwners = await response.json();
  return carOwners;
};

export const getCarOwnerById = async (ownerId) => {
  const response = await fetch(`${API_BASE_URL}/car-owner/${ownerId}`);
  const carOwner = await response.json();
  return carOwner;
};

export const updateCarOwner = async (owner, id) => {
  await fetch(`${API_BASE_URL}/car-owner/${id}`, {
    method: "PUT",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    body: JSON.stringify(owner),
  });

  alert(`[Owner ${id}] successfully updated`);
};

export const deleteCarOwnerById = async (id) => {
  await fetch(`${API_BASE_URL}/car-owner/${id}`, {
    method: "DELETE",
  });
  alert(`[Owner ${id}] successfully deleted`);
};

export const saveCarOwner = async (owner) => {
  await fetch(`${API_BASE_URL}/car-owner`, {
    method: "POST",
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    body: JSON.stringify(owner),
  });
  alert(`Owner successfully added`);
};
