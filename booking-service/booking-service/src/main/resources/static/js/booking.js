// Initialize on DOM load
document.addEventListener('DOMContentLoaded', function() {
    const fromSelect = document.getElementById("from");
    const toSelect = document.getElementById("to");

    // Update "to" dropdown when "from" changes
    fromSelect.addEventListener('change', updateToLocations);

    function updateToLocations() {
        const selectedFromId = fromSelect.value;
        
        // Reset all options
        Array.from(toSelect.options).forEach(opt => {
            opt.disabled = false;
            opt.hidden = false;
        });
        
        // Disable selected "from" location in "to" dropdown
        if (selectedFromId) {
            const selectedOption = toSelect.querySelector(`option[value="${selectedFromId}"]`);
            if (selectedOption) {
                selectedOption.disabled = true;
                selectedOption.hidden = true;
                
                // Auto-reset "to" if it matches the new "from"
                if (toSelect.value === selectedFromId) {
                    toSelect.value = "";
                }
            }
        }
    }
});