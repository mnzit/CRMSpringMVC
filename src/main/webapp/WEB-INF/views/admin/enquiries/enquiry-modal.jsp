<div class="modal fade" id="enquiry-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <form id="enquiry-form">
                <div class="modal-header">
                    <h5 class="modal-title"></h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Firstname</label>
                                <input type="text" class="form-control" id="firstname" name="firstName" required="required">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Lastname</label>
                                <input type="text" class="form-control" id="lastname" name="lastName" required="required">
                            </div>
                        </div>
                    </div><!--row-->
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Email</label>
                                <input type="email" class="form-control" id="email" name="email" required="required">
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Contact no</label>
                                <input type="text" class="form-control" id="contactno" name="contactNo" required="required">
                            </div>
                        </div>
                    </div><!--row-->
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Source</label>
                                <select name="enquirySourceId" class="form-control" id="enquiry-source-id">
                                </select>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Status</label>
                                <select name="enquiryStatusId" class="form-control" id="enquiry-status-id">
                                </select>
                            </div>
                        </div>
                    </div><!--row-->
                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Referred by</label>
                                <input type="text" class="form-control" id="referredby" name="referredBy" required="required">
                            </div>
                        </div>
                    </div><!--row-->
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary float-right btn-submit"><i class="fa fa-save"></i>Add</button>
                </div>
                <input type="hidden" id="id" name="id"/>
            </form>
        </div>
    </div>
</div>

<div class="modal fade" id="confirm-modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5>Delete</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
                <button type="button" class="btn btn-danger" id="delete-btn">Yes</button>
            </div>
        </div>
    </div>
</div>
