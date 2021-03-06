# DeliveryManagement System

Problem Statement #
Careem's vision is to become the biggest mover of people and goods across MENA. In this sphere, a major challenge is around the logistics of delivering shipments to customers. Build a platform that can work with commerce companies who need a shipment delivery service. The platform should be a B2B one where commerce companies will request quotations for their shipments and the platform will look into its transportation resources to find the most cost-effective and reliable way to deliver shipments. The platform will be provided some inputs on different hubs and transportation resources from that for the last mile delivery. For inter-city shipment delivery, the platform can work with partners to deliver the shipments through trains, flights and trucks if required. The partner information will also be part of the input to the platform and is expected to change.

#High Level Architecture Diagram <br />
![alt tag](https://github.com/naveennahata/deliverymgmt/blob/master/architecture.png)
<br />
<b> E2E Orchestrator : </b><br />
E2E Orchestrator take request from client (Client can be customer or vendor) and take care of entire End to End workflow.
<b>MDM (Master Data Management System) : </b><br />
This service will own MasterDate e.g. (Hub Related information etc) <br />
<b>User Service : </b><br />
User Service will hold customer/vendor related static information. <br />
![alt tag](https://github.com/naveennahata/deliverymgmt/blob/master/images/user_service.jpeg)
<b>Vendor Mgmt System </b><br />
It will manage all vendor related resource. <br />
![alt tag](https://github.com/naveennahata/deliverymgmt/blob/master/images/vendor_managment_service.jpg)
<b>Shipment/Consignment Mgmt System : </b><br />
Shipment Mgmt System will own all shipment related information. Shipment History, Details. <br />
![alt tag](https://github.com/naveennahata/deliverymgmt/blob/master/images/ConsignmentService.png) <br />
<b>Logistics Promising Engine : </b><br />
Logistics promising engine will take input from Planner, hold data in RadisCache with near real time update from planner, and provide plan with cost to shipmentMgmt while initially creating shipment. <br />
![alt tag](https://github.com/naveennahata/deliverymgmt/blob/master/images/LPE.png) <br />
<b>Planner : </b><br />
Planner is core engine to plan shipment deliveries. It take input from VendorMgmtSystem, and ShipmentMgmt to execute shipment deliveries. <br />
![alt tag](https://github.com/naveennahata/deliverymgmt/blob/master/images/Planner.png) <br />



