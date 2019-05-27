<div class="modal fade" id="followup-modal">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLongTitle">Follow ups</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="input-form">
                    <form id="followup-form">
                        <div class="form-group">
                            <label>Message</label>
                            <input type="text" class="form-control" name="message" required="required" id="message">
                        </div><!--form-group-->
                        <div class="form-group">
                            <label>Status</label>
                            <select name="followUpStatusId" id="followup-status" class="form-control">
                            </select>
                        </div><!--form-group-->
                        <input type="hidden" value="" name="enquiryId" id="enquiryid">
                        <button id="save-followup-btn" type="submit" class="btn btn-primary float-right btn-sm"><i class="fa fa-save"></i> Add</button>
                    </form>
                </div>
                <div id="followup-content"></div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
            </div>
        </div>
    </div>
</div>